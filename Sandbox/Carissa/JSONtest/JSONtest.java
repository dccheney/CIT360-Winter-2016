package JSONtest;

/**
 * Created by Carissa on 3/3/2016.
 */

    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    //import java.util.Date;
    import java.util.HashMap;

    import org.quickconnectfamily.json.*;
    import java.io.File;
    import java.util.Iterator;
    import java.util.Map;

/**
     * Created by newuser on 1/28/16.
     */
    public class JSONtest {

        public static void main(String[] args) {

            try {
        	/*
        	 * JSON file IO example.  Socket IO would be done the same way
        	 * except that the output and input streams would be retrieved
        	 * from a socket rather than created.
        	 */
                File myFile = new File("myFileData.txt");
                FileOutputStream fileOut = new FileOutputStream(myFile);
                FileInputStream fileIn = new FileInputStream(myFile);

                JSONOutputStream jsonOut = new JSONOutputStream(fileOut);
                JSONInputStream jsonIn = new JSONInputStream(fileIn);

                JSONbean car1 = new JSONbean("Honda", "Civic", 2001,"silver");
                JSONbean car2 = new JSONbean("pontiac", "Grand Am", 1998,"red");
                JSONbean car3 = new JSONbean("Lincoln", "Towncar", 1992,"silver");
                JSONbean car4 = new JSONbean("Hyundai", "Tiburon", 2001,"silver");

                //writes the data into a file
                jsonOut.writeObject(car1);
                jsonOut.writeObject(car2);
                jsonOut.writeObject(car3);
                jsonOut.writeObject(car4);

                //jsonIn.readObject reads data and store it to a hashmap
                HashMap parsedJSONMap = (HashMap) jsonIn.readObject();

                //comapares data
                JSONbean readObject = new JSONbean(parsedJSONMap);
                JSONbean readObject2 = new JSONbean(parsedJSONMap);

                Iterator it = parsedJSONMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    System.out.println(pair.getKey() + " = " + pair.getValue());

                }
                System.out.println(readObject);
                System.out.println("stream same? "+readObject.equals(car1));
                System.out.println(readObject2);
                System.out.println("stream same? "+readObject2.equals(car2));

                System.out.println(parsedJSONMap.get("model"));

                String jsonString1 = JSONUtilities.stringify(car1);
                System.out.println("JSON: "+jsonString1);
                String jsonString2 = JSONUtilities.stringify(car2);
                System.out.println("JSON: "+jsonString2);
                String jsonString3 = JSONUtilities.stringify(car3);
                System.out.println("JSON: "+jsonString3);
                String jsonString4 = JSONUtilities.stringify(car4);
                System.out.println("JSON: "+jsonString4);

                parsedJSONMap = (HashMap)JSONUtilities.parse(jsonString2);
                readObject = new JSONbean(parsedJSONMap);
                System.out.println("stringify same? "+readObject.equals(car2));
                System.out.println("stream same? "+readObject.equals(car2));

                //nasty paths

                JSONbean car5 = new JSONbean(null,"\n",null,null);
                jsonOut.writeObject(car5);

                String jsonString5 = JSONUtilities.stringify(car5);
                System.out.println("JSON: "+jsonString5);

            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

    }
