
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class UniversalPrint {
    
    
    
    public static void print(String numbs,boolean fullPrint,String year,String clientName){
        int[] id_docs;
        int[] id_skls;
        try{
            String SQL=String.format("select count(*) from document where numb in (%s) and to_char(day,'YYYY')='%s'", numbs,year);
            ResultSet rs=DataSet.QueryExec(SQL, false);
            rs.next();
            id_docs=new int[rs.getInt(1)];
            id_skls=new int[rs.getInt(1)];
            SQL=String.format("select id_doc,id_skl from document where numb in (%s) and to_char(day,'YYYY')='%s'", numbs,year);
            rs=DataSet.QueryExec(SQL, false);
            for (int i=0;i<id_docs.length;i++){
                rs.next();
                id_docs[i]=rs.getInt(1);
                id_skls[i]=rs.getInt(2);
            }
            printDocs(id_docs, id_skls, true, true, clientName);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void print(String name, int[] id_docs){
        
    }
    
    public static void print(String name){
        
    }

    private static boolean printDocs(int[] id_docs,int[] id_skls,boolean fullPrint,boolean isOpt,String clientName){
        NumberFormat formatter = new DecimalFormat ( "0.00" );
        Vector<Vector<String>> OutData = new Vector<Vector<String>>(0);                    
        try{
                                boolean first=true;
				int startRow=0;
//				while (rs.next()){
                                String id_docsAsString="";
                                
                                for (int id_doc:id_docs){
                                    id_docsAsString=id_docsAsString+id_doc+", ";
                                }
                                id_docsAsString=id_docsAsString.substring(0, id_docsAsString.lastIndexOf(", "));
                                ResultSet rs;
                                rs=DataSet.QueryExec(String.format("Select sum(document.sum*curs_now.curs) from document, curs_now where curs_now.id_val=document.id_val and document.id_type_doc=2 and id_doc in (%s) ",id_docsAsString),false );
				rs.next();
				//sum=rs.getDouble(1);
				String Suma=formatter.format(rs.getDouble(1))+" руб.";
                                String curs_USD="";
                                rs=DataSet.QueryExec("Select curs from curs_now where id_val=22", false);
			
                                if (rs.next())
                                    curs_USD= formatter.format(rs.getDouble(1));
                                for(int k=0;k<id_docs.length;k++){
//					Doc_count++;
					int id=id_docs[k];
                                        int skl=id_skls[k];
//					int skl=rs.getInt(2);
					boolean last=k==id_docs.length-1;
                                        
//					DataSet.UpdateQuery("update document set numb=numb_real.nextval, day=sysdate where id_doc="+id);
					if (isOpt)
						rs=DataSet.QueryExec("select trim(tovar.name), tovar.kol, sum(lines.kol), cost, disc, sum(lines.kol*cost*(1-disc/100)) from lines inner join tovar on lines.id_tovar=tovar.id_tovar where id_doc="+id+" group by tovar.name, tovar.kol, cost, disc order by tovar.name", false);
					else{
						String SQLr=(skl==2 | skl==3)?specialPrintForShop(id,skl):"select trim(tovar.name), sum(lines.kol*tovar.kol), cost/tovar.kol, sum(lines.kol*cost) from lines inner join tovar on lines.id_tovar=tovar.id_tovar where id_doc="+id+" group by tovar.name, cost/tovar.kol order by "+(skl!=8?"tovar.name":"substr(upper(trim(tovar.name)),instr(trim(tovar.name),' ')+1),to_number(substr(upper(trim(tovar.name)),1,instr(trim(tovar.name),' ')-1),'999999999.99')");
						rs=DataSet.QueryExec(SQLr, false);
					}
					for (int i=0; i<OutData.size();i++)
						OutData.get(i).clear();
					OutData.clear();
					int j=0;
					double SumWithoutDiscount=0.00;
					while (rs.next()){
						Vector<String> Row=new Vector<String>(0);
						j++;
						Row.add(j+"");
						if (isOpt){
							SumWithoutDiscount=SumWithoutDiscount+rs.getDouble(3)*rs.getDouble(4);
							Row.add(rs.getString(1));
							Row.add(rs.getString(3));
							Row.add(formatter.format(rs.getDouble(4)));
							Row.add(rs.getString(5));
							Row.add(formatter.format(rs.getDouble(4)*(1-rs.getDouble(5)/100)));
							Row.add(formatter.format(rs.getDouble(6)));
						}else{
							Row.add(rs.getString(1));
							Row.add(rs.getString(2));
							Row.add(formatter.format(rs.getDouble(3)));
							Row.add(formatter.format(rs.getDouble(4)));
						}
						OutData.add(Row);
					}
					rs=DataSet.QueryExec("select sum, trim(note), disc, trim(val.name), trim(manager.name), trim(sklad.name),numb from ((document inner join val on document.id_val=val.id_val) inner join manager on document.id_manager=manager.id_manager) inner join " +
							"sklad on document.id_skl=sklad.id_skl where id_doc="+id, false);
					String pref="";
					rs.next();
					if (rs.getString(2).charAt(0)=='&')
						pref=" (АКЦИЯ)";
					GregorianCalendar now=new GregorianCalendar();

					int size=OutData.size();
					if (isOpt) 
						{
						OutputOO.OpenDoc("nakl_opt_new.ots",true,false);
						if (first&&fullPrint){
							OutputOO.OpenDoc("nakl_sum_new.ots",true,true);
							OutputOO.InsertOne("\""+now.get(Calendar.DAY_OF_MONTH)+"\" "+Month(now.get(Calendar.MONTH))+" "+now.get(Calendar.YEAR)+"г.", 10, true, 5,1,true);
							OutputOO.InsertOne("Получатель: "+clientName,11, true, 1,4,true);

						}
						OutputOO.InsertOne("\""+now.get(Calendar.DAY_OF_MONTH)+"\" "+Month(now.get(Calendar.MONTH))+" "+now.get(Calendar.YEAR)+"г.", 10, true, 5,1,false);
						OutputOO.InsertOne("Получатель: "+clientName,11, true, 1,4,false);
						boolean repeat=false;
						do{
							OutputOO.InsertOne("Накладная №"+rs.getString(7)+pref, repeat?11:16, true, repeat?2:1, (repeat?startRow:0)+2,repeat);
							OutputOO.InsertOne(rs.getString(2).substring(1),8,false,1,(repeat?startRow+3+(first?3:0):6),repeat);
							OutputOO.InsertOne("Склад: "+rs.getString(6),7,false,repeat?6:7,(repeat?startRow+4+(first?3:0):7),repeat);
							OutputOO.InsertOne("Валюта: "+rs.getString(4),7,false,1,(repeat?startRow+4+(first?3:0):7),repeat);
							OutputOO.InsertOne("ИТОГО:",10,false,2,(repeat?startRow+6+(first?3:0):9)+size,repeat);
							OutputOO.InsertOne(formatter.format(SumWithoutDiscount),10,false,7,(repeat?startRow+6+(first?3:0):9)+size,repeat);
							OutputOO.InsertOne("Скидка",10,false,2,(repeat?startRow+6+(first?3:0):9)+size+1,repeat);
//							OutputOO.InsertOne(formatter.format(),10,false,5,(repeat?startRow+6+(first?3:0):9)+size+1,repeat);
							OutputOO.InsertOne(formatter.format(SumWithoutDiscount-rs.getDouble(1)),10,false,7,(repeat?startRow+6+(first?3:0):9)+size+1,repeat);
							OutputOO.InsertOne("Итого со скидкой",10,false,2,(repeat?startRow+6+(first?3:0):9)+size+2,repeat);
							OutputOO.InsertOne(formatter.format(rs.getDouble(1)),10,true,7,(repeat?startRow+6+(first?3:0):9)+size+2,repeat);
							OutputOO.InsertOne("Документ оформил: "+rs.getString(5),8,false,2,(repeat?startRow+6+(first?3:0):9)+size+4,repeat);
							if (last&&fullPrint) {
								OutputOO.InsertOne("Итого по всем накладным ("+id_docs.length+" шт.): "+Suma+" (курс USD="+curs_USD+")",10,true,2,(repeat?startRow+6+(first?3:0):9)+size+6,repeat);
//								if (SALE && amountOfDiscount>0)
//									OutputOO.InsertOne(messageDiscount,10,true,2,(repeat?startRow+6+(first?3:0):9)+size+8,repeat);
							}
							repeat=!repeat;
						}while(repeat);
						}
					else
						{
						OutputOO.OpenDoc("nakl_roz.ots",true,false);
						OutputOO.InsertOne("\""+now.get(Calendar.DAY_OF_MONTH)+"\" "+Month(now.get(Calendar.MONTH))+" "+now.get(Calendar.YEAR)+"г.", 10, true, 3,1,false);
						OutputOO.InsertOne("Накладная №"+rs.getString(7)+pref, 16, true, 1, 2,false);
						OutputOO.InsertOne("Получатель: "+clientName,11, true, 1,4,false);
						OutputOO.InsertOne(rs.getString(2).substring(1),8,false,1,6,false);
						OutputOO.InsertOne("Склад: "+rs.getString(6),7,false,5,7,false);
						OutputOO.InsertOne("Итого:",10,false,2,9+size,false);
						OutputOO.InsertOne(formatter.format(rs.getDouble(1)),10,true,5,9+size,false);
						OutputOO.InsertOne("Документ оформил: "+rs.getString(5),8,false,2,9+size+2,false);

						}
					OutputOO.Insert(1, 9, OutData,false);
					OutputOO.Insert(1, startRow+6+(first?3:0), OutData,true);
					startRow=startRow+size+(first?14:11);					
					if (isOpt){
						OutputOO.print(1,false);
						if (last){
							OutputOO.print(1,true);
							OutputOO.CloseDoc(true);
						}
					}
					else{
						OutputOO.print(3,false);
					}
					OutputOO.CloseDoc(false);
					first=false;
				}    
                            }catch(Exception ex){
                                ex.printStackTrace();
                                return false;
                            }
        return true;
    }
    
    private static String specialPrintForShop(int id, int skl) throws Exception{
		String name="";
		int prefixBarCode=0;
		if (skl==2){
			name=" Очки с/з";
			prefixBarCode=60000;
		}
		
		if (skl==3){
			name=" Шляпа";
			prefixBarCode=1392306;
		}
		String LocateSQL=String.format("select distinct cost from lines where not (cost in (select price from glassforshop where id_skl=%s)) and id_doc=%s",skl, id);
		ResultSet rs1=DataSet.QueryExec(LocateSQL, false);
		try{
			while (rs1.next()){
				LocateSQL=String.format("Insert into glassforshop (name,barcode,price,id_skl) values ('%s','%s',%s,%s)",rs1.getInt(1)+name,BarCode.GenerateBarCode(prefixBarCode,true),rs1.getString(1),skl );
				DataSet.UpdateQuery1(LocateSQL);
			}
			DataSet.commit1();
		}catch(Exception e){
			e.printStackTrace();
			DataSet.rollback1();
			JOptionPane.showMessageDialog(null, "Ошибка записи новых штрих кодов");
		}
		return String.format("select trim(gfs.name), sum(l.kol),l.cost,sum(l.kol)*l.cost from glassforshop gfs,lines l where gfs.price=l.cost and id_doc=%s and gfs.id_skl=%s group by l.cost,trim(gfs.name), trim(gfs.barcode) order by l.cost", id, skl);
	}
    	private static String Month(int aValue){
		switch (aValue+1){
		case 1:return "января";
		case 2:return "февраля";
		case 3:return "марта";
		case 4:return "апреля";
		case 5:return "мая";
		case 6:return "июня";
		case 7:return "июля";
		case 8:return "августа";
		case 9:return "сентября";
		case 10:return "октября";
		case 11:return "ноября";
		case 12:return "декабря";
		default: return "";
		}
	}
}
