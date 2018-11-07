/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dom;

import java.io.File;
import java.util.jar.Attributes;
import javax.xml.parsers.SAXParserFactory;
import jdk.internal.org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author xp
 */
public class SAX {
    
    
    
    public int abrir_XML_SAX(File fichero)
    {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            
            parser =factory.newSAXParser();
            
            
            
            sh = new ManejadorSAX();
            
            
            ficheroXML = fichero ;
            
            return 0 ;
            
            
            
            
            
            
            
            
            
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
            return -1;
        }
        
        
     class ManejadorSAX extends DefaultHandler{
         
        int ultimoelement;
        String cadena_resultado ="";
        
        
        public ManejadorSAX(){
            ultimoelement=0;
        }
         
         @Override public void  startElement(String uri , String localName , String qName , Attributes atts)throws SAXException{
             if(qName.equals("Libro")){
                 cadena_resultado = cadena_resultado +"\nPublicado en :"
                         + atts.getValue(atts.getQName(0))+ "\n";
                 
                         ultimoelement=1;
             }
             
             
             else if(qName.equals("Titulo")){
                 ultimoelement = 2;
                 cadena_resultado = cadena_resultado + "\nEL titulo es:";
                 
                         
             }
             else if(qName.equals("Autor")){
                 ultimoelement = 3;
                 cadena_resultado = cadena_resultado + "\nEL autor es:";
                 
                         
             }
             
         }
         
         
       @Override public void andElement(String uti,String localName,String qName)
               throws SAXException{
           if(qName.equals("Libro")){
               System.out.println("He encontrado el final de un elemento.");
               cadena_resultado = cadena_resultado + "\n ---------";
               
           }
       }
         
         
         @Override public void characters(char[]ch , int start , int lenght)throws
                    SAXException{
             
                    if(ultimoelement ==2){
                        for(int i = start ; i<lenght+start ; i++)
                            cadena_resultado =cadena_resultado+ch[i];
                    }
                    else if(ultimoelement ==3 ){
                            for(int i = start ; i<lenght+start ; i++)
                            cadena_resultado =cadena_resultado+ch[i];
                    }
                    }
         }
         
         
         
    
         
         
         
         
         
 
         
       
        
        
        
        
        
        
    }
    
    public String recorrerSAX (File fXML,ManejadorSAX sh , SAXParser parser){
        
        try {
            parser.parser(fXML,sh);
            return sh.cadena_resultado;
            
            
            
            
            
            
        } catch (SAXException e) {
            e.printStackTrace();return"Error al parsear con SAX";
            
        }catch (Exception e) {
            e.printStackTrace();return"Error al parsear con SAX";
            
        }
       
            
                
        
    }
    
    
    
    
    
    
}
    
    
    
    
