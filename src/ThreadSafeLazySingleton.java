public class ThreadSafeLazySingleton {

    private static ThreadSafeLazySingleton singleton;

    private static int count;
    private String name;

    private ThreadSafeLazySingleton(){
        name = "ThreadSafeLazySingleton" +count;
        count++;
    }
    public static ThreadSafeLazySingleton getInstance()
    {
        if(singleton == null)
        {
            synchronized (ThreadSafeLazySingleton.class)
            {
                if(singleton == null)
                {
                    try {
                        Thread.currentThread().sleep(1);
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    singleton = new ThreadSafeLazySingleton();
                }
            }
        }
        return singleton;
    }

    public void printName()
    {
        System.out.println(name);
    }




}
