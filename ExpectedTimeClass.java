public class ExpectedTimeClass 
{
    private int    projectNumber;
    private String projectName;
    private int    optimisticTime;
    private int    realisticTime;
    private int    pessimisticTime;	

    // Constructor (Default)
    public ExpectedTimeClass()
    {
        projectNumber   = 1;
        projectName     = "Project Test";
        optimisticTime  = 1;
        realisticTime   = 1;
        pessimisticTime = 1;
        
    }
    
    // Constructor
    public ExpectedTimeClass(int projectNumber,   String projectName,
                             int optimisticTime,  int realisticTime,
                             int pessimisticTime)
    {
        this.projectNumber   = projectNumber;
        this.projectName     = projectName;
        this.optimisticTime  = optimisticTime;
        this.realisticTime   = realisticTime;
        this.pessimisticTime = pessimisticTime;
    }
    
    // Method to set the project number
    public void setProjectNumber(int projectNumber)
    {
        this.projectNumber = projectNumber;
    }
    
    // Method to get the project number    
    public int getProjectNumber()
    {
        return projectNumber;
    }

    // Method to set the project name
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }
    
    // Method to get the project name    
    public String getProjectName()
    {
        return projectName;
    }

    // Method to set the optimistic time    
    public void setOptimisticTime(int optimisticTime)
    {
        this.optimisticTime = optimisticTime;
    }
    
    // Method to get the optimistic time
    public int getOptimisticTime()
    {
        return optimisticTime;
    }
    
    // Method to set the realistic time
    public void setRealisticTime(int realisticTime)
    {
        this.realisticTime = realisticTime;
    }
    
    // Method to get the realistic time
    public int getRealisticTime()
    {
        return realisticTime;
        
    }
    
    // Method to set the pessimistic time    
    public void setPessimisticTime(int pessimisticTime)
    {
        this.pessimisticTime = pessimisticTime;
    }
    
    // Method to get the pessimistic time
    public int getPessimisticTime()
    {
        return pessimisticTime;
    }
    
    //Method to calculate the expected time
    public float calculateExpectedTime()
    {
        // Define the local variable
        float expectedTime;
        
        // Calculate the expected time
        expectedTime = (optimisticTime + ( 4.0f * realisticTime ) 
                        + pessimisticTime ) / 6.0f;
        
        return expectedTime;
    }
    
} 
