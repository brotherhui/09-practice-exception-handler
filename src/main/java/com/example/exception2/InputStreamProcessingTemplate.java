package com.example.exception2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class InputStreamProcessingTemplate {
    public void process(String fileName){
        IOException processException=null;
        InputStream input=null;
        try{
            input=new FileInputStream(fileName);
            doProcess(input);
        }catch(IOException e){
            processException=e;
        }finally{
            if(input!=null){
                try{
                    input.close();
                }catch(IOException e){
                    if(processException!=null){
                        throw new EnrichableException("error1","open","An Exception Happen in try",processException);
                    }else{
                        throw new EnrichableException("error2","close","An Exception Happen in finally",e);
                    }
                }
            }
            if(processException!=null){
                throw new EnrichableException("error1","Error processing InputStream for file "+fileName,"end",processException);
            }
        }
    }

    public abstract void doProcess(InputStream in);
}
