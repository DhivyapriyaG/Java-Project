import java.util.*;
import java.io.*;
class Main{
    static Scanner sc=new Scanner(System.in);
    static ArrayList<List> csh=new ArrayList<List>(); 
    static ArrayList<List> stc=new ArrayList<List>();
    static ArrayList al=new ArrayList<>();
    static int i=0,billId=1,cId=1000;
    
    static void cashierfunc()
    {
        boolean fla=true;
        System.out.println("\t\t         Welcome to Cashier Page");
        while(true)
        {
            System.out.println("Main Menu : ");
            System.out.println("\n\t1.AddStock\n\t2.ViewStock\n\t3.removeStock\n\t4.newBill\n\t5.viewBill\n\t6.Logout");
            try
            {
                System.out.print("\nEnter a Choice : ");
                int choice=sc.nextInt();
                if(choice==1)
                {
                    while(true)
                    {
                        try
                        {
                            System.out.print("\nHow many stock is going to be Added : ");
                            int n=sc.nextInt();
                            for(int i=0;i<n;i++)
                            {
                                System.out.print("\n                Enter the ITEM Name : ");
                                String stname=sc.next();
                                System.out.print("                        Stock Count : ");
                                double stccou=sc.nextDouble();
                                System.out.print("     Enter costprice of SingleStock : ");
                                double stcpri=sc.nextDouble();
                                System.out.print("           Enter tax of SingleStock : ");
                                double stctax=sc.nextDouble();
                                for(List d:stc)
                                {
                                    if(((String)d.get(0)).equals(stname)) fla=false;
                                    d.set(1,stccou+((Double)d.get(1)));

                                }
                                if(fla)
                                stc.add(Arrays.asList(stname,stccou,stcpri,stctax));
                                fla=true;
                            }
                        }
                        catch(Exception e)
                        {
                            System.out.println("\t\t          Please Check Your Option..!");
                        }
                    }
                }
                else if(choice==2)
                {
                    File sl=new File("stocks.txt");
                    sl.createNewFile();
                    PrintWriter fg=new PrintWriter(sl);
                    System.out.println("===================================================");
                    System.out.println("Stock Name   stock count   CP of Single unit   Tax ");
                    fg.printf("Stock Name   stock count   CP of Single unit   Tax \n");
                    System.out.println("----------   -----------   -----------------   ----");
                    for(List l:stc)
                    {
                        System.out.printf("%-10s   %-11f   %-17f   %-4.2f\n",l.get(0),l.get(1),l.get(2),l.get(3));
                        fg.printf("%-10s   %-11f   %-17f   %-4.2f\n",l.get(0),l.get(1),l.get(2),l.get(3));
                    }
                    System.out.println("===================================================");
                    fg.close();
                }

                else if(choice==3)
                {
                    System.out.print("Enter Your RemoveStockName:");
                    String rname=sc.next();
                    int i=0;
                    try{
                        for(List k:stc)
                        {
                        
                            if(rname.equalsIgnoreCase(k.get(0).toString()))
                            stc.remove(i);
                            i++;
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("");
                    }


                }
                else if(choice==4)
                {
                    boolean f=true;
                    ArrayList s=null;
                    ArrayList  s1=null;
                    s1=new ArrayList<>(); s=new ArrayList<>();
                    Double to=0.0;
                    
                    while(true)
                    {  
                        System.out.print("\nEnter Stock Name         : ");String neStockname=sc.next();
                        System.out.print("how many you want(count) : ");Double neStockcount=sc.nextDouble();
                        for(List k:stc)    
                        {
                            if(k.get(0).equals(neStockname)&&(Double)k.get(1)>=neStockcount)
                            { 
                                Double t=Double.parseDouble(k.get(3).toString());
                                Double f1=Double.parseDouble(k.get(2).toString());
                                Double e=((t/100.0*f1)+f1)*neStockcount;
                                s.add((String)k.get(0));
                                s.add((Double)neStockcount);
                                s.add((Double)k.get(2));
                                s.add((Double)k.get(3));
                                s.add((Double)e);
                                s.add(e+to);
                                to+=e;
                                s1.add(s);
                                k.set(1,(Double)k.get(1)-neStockcount);
                                f=false;
                                s=new ArrayList<>();
                            }
                            
                        }
                        System.out.print("\nDo yo want yes/no : ");
                        if(sc.next().equals("no")) break;
                    }
                    if(f)
                    System.out.println("\n\t       Recheck the Stock Name...!");
                    al.add(s1);
                }

                else if(choice==5)
                {
                    File sl=new File("newbill.txt");
                    sl.createNewFile();
                    PrintWriter fb=new PrintWriter(sl);
                    int n=5,i,j;
                    System.out.println("StockName     stockcount     singleprice        tax          total");
                    fb.printf("StockName     stockcount     singleprice        tax          total\n");
                    for(Object k:al)
                    {
                        for( i=0;i<((ArrayList)k).size();i++)
                        {
                            
                            System.out.printf("%-9s     %-10f     %-11f     %-3f     %-5f\n",((ArrayList)((ArrayList)k).get(i)).get(0),((ArrayList)((ArrayList)k).get(i)).get(1),((ArrayList)((ArrayList)k).get(i)).get(2),((ArrayList)((ArrayList)k).get(i)).get(3),((ArrayList)((ArrayList)k).get(i)).get(4));
                            fb.printf("%-9s     %-10f     %-11f     %-3f     %-5f\n",((ArrayList)((ArrayList)k).get(i)).get(0),((ArrayList)((ArrayList)k).get(i)).get(1),((ArrayList)((ArrayList)k).get(i)).get(2),((ArrayList)((ArrayList)k).get(i)).get(3),((ArrayList)((ArrayList)k).get(i)).get(4));
                            System.out.println();
                            if(i==((ArrayList)k).size()-1)
                            {
                                System.out.println("======================================================================");
                                System.out.println("                                                  THETOTAL:"+((ArrayList)((ArrayList)k).get(i)).get(5));
                                fb.printf("                                                    THETOTAL:%-5f\n",((ArrayList)((ArrayList)k).get(i)).get(5));
                            }
                        }
                        System.out.println("======================================================================");
                    }
                    fb.close();
                }
                else if(choice==6) break;
            }

            catch(Exception e)
            {
                sc.next();
            }
        }
    }

    static void Cashier()
    {
        int f=0;
        System.out.print("\n\t\t        Cashier Login Page");
        System.out.print("\nEnter the name : ");
        String csname=sc.next();
        System.out.print("Enter the Id   : ");
        String cspass=sc.next();
        for(List k:csh)
        {
            //if(csname.equals(k.get(0))&&cspass.equals(k.get(1)))
            if(((String)k.get(0)).equals(csname) && ((String)k.get(1).toString()).equals(cspass))
            {
                System.out.println("\n\t\t        Login Succesfull.......\n");
                cashierfunc();
                f=1;
                break;
            }
        }
        if(f==0)
            System.out.println("\n\t\t   Oops!.. Something went wrong");
    }

    static void Owner() throws IOException
    {
        System.out.println("\n\t\t     LogIn Successfull..!");
        boolean f1=true; File 
        fl=new File("casheirs.txt");
        fl.createNewFile();
            PrintWriter out=new PrintWriter(fl);
        out.printf(" CashierName     Password \n");
        out.printf("|-----------     --------|\n");
    
        while(true)
        {
            System.out.print("\nMain Menu :");
            System.out.println("\n\n\t1.AddCashier\n\t2.ViewCashier\n\t3.removeCashier\n\t4.logout");
            try
            {
                System.out.print("\nEnter Your Choice : ");
                int choice=sc.nextInt();
                if(choice==1)
                {
                    System.out.println("\nAdding Cashier :");
                    System.out.print("\nEnter Cashier Name : ");
                    String csname=sc.next();    
                    System.out.printf("Enter id           : %d",cId);
                    
                    for(List d:csh)
                    {
                        if(((int)d.get(1))==(cId)) f1=false;
                    }
                    if(f1)
                    {
                        csh.add(Arrays.asList(csname,cId));
                        out.printf("|%-11s     %-8s|\n",csname,cId);
                    }

                    else
                        System.out.println("\n\t\t       This Id already exists....");

                    if(f1)
                        System.out.println("\n\n\t\t....... Cashier added Succesfully.......");
                        cId++;
                    f1=true; 
                }

                else if(choice==2)
                {
                    System.out.printf("\n CashierName        Id \n");
                    System.out.printf("|-----------     --------|\n");
                    for(List k:csh)
                    {
                        System.out.printf("|%-11s     %-8s|\n",k.get(0),k.get(1));
                        System.out.println("|                        |");
                    }
                    
                    System.out.printf("|========================|\n");
                }
                else if(choice==3)
                {
                    int i=0,f=0;
                    System.out.print("\nEnter the Id to be removed : ");
                    
                    try
                    {
                        int rname=sc.nextInt();
                        for(List k:csh)
                        {
                            if (((int)k.get(1))==(rname))
                            {
                                csh.remove(i);
                                f=1;
                                break;
                            }
                            i++;
                        }
                        if(f==0)
                        {
                            System.out.println(("\n\t      No such cashier exists..! Try Again."));
                        }
                        else if(f==1)
                        {
                            System.out.println(("\n\t        Removed Cashier Successfully..!"));
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("");
                    }
                }   
                else if(choice==4)
                {
                    System.out.println("\n\t\t    Logged Out Successfully..!");
                    break;
                }
                else System.out.println("\n\t\t       Enter Correct Option..!");
            }
            catch(Exception e)
            {
                System.out.println("\n\t\t  Please check your Option..!");
            }
        } out.close();
    }
    public static void main(String[] args)throws IOException 
    {   
        while(true)
        {
            try
            {
                String choice;
                System.out.println("\n\t\t*** WELCOME TO DEPARTMENTAL STORE ***");
                System.out.print("\nLogin as :");
                System.out.println("\n\n\t1.Owner\n\t2.Cashier\n\t3.Exit");
                System.out.print("\nEnter Your Option : ");
                choice=sc.next();
                if (choice.equals("1"))
                {                
                    System.out.print("\n\t\t             Owner Login Page");
                    System.out.print("\nEnter Owner Name : ");
                    String oname=sc.next();
                    System.out.print("Enter Password   : ");
                    String opass=sc.next();
                    if(oname.equalsIgnoreCase("owner")&&(opass.equals("1111")))
                    {
                        Owner();
                    }
                    else System.out.println("\n\t        Please Check Your Entered details..!");
                }
                else if (choice.equals("2"))
                {
                    Cashier();
                }
                else if (choice.equals("3"))
                {
                    break;
                }
                else    System.out.println("\n\t        Please Check Your Entered details..!");
                
            }
            catch(Exception e)
            {
                System.out.println("\t        Please Check Your Entered details..!");
            }
        }
            
    }
   
}

