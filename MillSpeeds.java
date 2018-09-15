 class MillSpeeds{

     String material;
     int cuttingSpeed;
     
      public void setMaterial(String mat)
     {
        mat = this.material;
        }
     
     public String getMaterial(String mat)
     {
        return mat;
        }
     
         public void getCuttingSpeed(int cS)
     {
        cS = this.cuttingSpeed;
        }
     
     public int setCuttingSpeed(int cS)
     {
        return cS;
        }
     
     public String showStats()
     {
       return "Material: "+ material + "Cutting Speeds: "+ cuttingSpeed;    
     }
        
     public MillSpeeds(String material, int cuttingSpeed)
     {
        
     
           }
 
        }
     
     
    