class A extends Thread
{
    public void run()
	{
		synchronized(this){
		for(int i=0;i<3;i++)
		{
			System.out.println(i);
		}
		try{
		wait();}
		catch(Exception e){}
		}
		System.out.println("i got notlfy ");
		//this.notify();
		for(int j=0;j<3;j++)
		{
			System.out.println("a");
			Thread.yield();
		}
	}
}
class B implements Runnable
{
	public void run()
	{
		notify();
		synchronized(this){
		for(int i=0;i<3;i++)
		{
			System.out.println("loga");
		}
		this.notifyAll();
		}
		
	}
   
	
	
	
}

class C
{
	public static void main(String args[])
	{
	A oa=new A();
	B ob=new B();
	Thread oc=new Thread(ob);
	oa.start();
	oc.start();
	}
}