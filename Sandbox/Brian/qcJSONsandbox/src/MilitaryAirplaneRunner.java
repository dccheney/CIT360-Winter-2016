import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Exchanger;



/**
 * Created by brian on 3/6/16.
 */
public class MilitaryAirplaneRunner
{
    public static void main(String[] args)
    {

        //Create a file container
        File aFile = new File("/Users/brian/Desktop/test.json");
        File unwrittableFile = new File("/Users/brian/Desktop/unwriteableJSONfile.json");



        try
        {
            //sending a FileOutputStream object to the constructor of the JSONOutputStream.
            FileOutputStream aFileStream = new FileOutputStream(aFile);
            JSONOutputStream jsonOut = new JSONOutputStream(aFileStream);

            MilitaryAirplane airplane1 = new MilitaryAirplane("Eagle", "Fighter", "F-15", "McDonnell Douglas", "Air superiority fighter", "United States Air Force");
            MilitaryAirplane airplane2 = new MilitaryAirplane("Raptor", "Fighter", "F-22", "Lockheed Martin", "Air superiority fighter", "United States Air Force");
            MilitaryAirplane airplane3 = new MilitaryAirplane("Hornet", "Strike Fighter", "F/A-18", "McDonnell Douglas", "Multirole Strike Fighter", "United States NAVY");
            MilitaryAirplane airplane4 = new MilitaryAirplane("Stratofortress", "Bomber", "B-52", "Boeing", "Strategic bombing", "United States Air Force");
            MilitaryAirplane airplane5 = new MilitaryAirplane("Lancer", "Bomber", "B-1", "Rockwell International", "Supersonic heavy strategic Bomber", "United States Air Force");
            MilitaryAirplane airplane6 = new MilitaryAirplane("Spirit", "Bomber", "B-2", "Northrop", "Strategic Stealth Bomber", "United States Air Force");

            // writes objects into a file
            jsonOut.writeObject(airplane1);
            jsonOut.writeObject(airplane2);
            jsonOut.writeObject(airplane3);
            jsonOut.writeObject(airplane4);
            jsonOut.writeObject(airplane5);
            jsonOut.writeObject(airplane6);

            try
            {
                FileInputStream aFileInStream = new FileInputStream(aFile);
                JSONInputStream jsonIn = new JSONInputStream(aFileInStream);

                //jsonIn.readObject reads data and store it to a hashmap
                HashMap jsonMap  = (HashMap)jsonIn.readObject();
                HashMap jsonMap2 = (HashMap)jsonIn.readObject();
                HashMap jsonMap3 = (HashMap)jsonIn.readObject();
                HashMap jsonMap4 = (HashMap)jsonIn.readObject();
                HashMap jsonMap5 = (HashMap)jsonIn.readObject();
                HashMap jsonMap6 = (HashMap)jsonIn.readObject();
                System.out.println("===========================");
                System.out.println(jsonMap.toString());
                System.out.println(jsonMap2.toString());
                System.out.println(jsonMap3.toString());
                System.out.println(jsonMap4.toString());
                System.out.println(jsonMap5.toString());
                System.out.println(jsonMap6.toString());
                System.out.println("\n");

                //JSON String representation of an instance of the MilitaryAirplane class
                //keys == class attribute names
                //values == instances
                String jsonString = JSONUtilities.stringify(airplane1);
                System.out.println(jsonString);
                String jsonString2 = JSONUtilities.stringify(airplane2);
                System.out.println(jsonString2);
                String jsonString3 = JSONUtilities.stringify(airplane3);
                System.out.println(jsonString3);
                String jsonString4 = JSONUtilities.stringify(airplane4);
                System.out.println(jsonString4);
                String jsonString5 = JSONUtilities.stringify(airplane5);
                System.out.println(jsonString5);
                String jsonString6 = JSONUtilities.stringify(airplane6);
                System.out.println(jsonString6 + "\n\n\n");

                //To convert a JSON string to an instance you use the
                //JSONUtilities.parse method passing it the JSON string to be converted
                HashMap parseMap = (HashMap) JSONUtilities.parse(jsonString);
                System.out.println(parseMap);
                parseMap = (HashMap) JSONUtilities.parse(jsonString2);
                System.out.println(parseMap);
                parseMap = (HashMap) JSONUtilities.parse(jsonString3);
                System.out.println(parseMap);
                parseMap = (HashMap) JSONUtilities.parse(jsonString4);
                System.out.println(parseMap);
                parseMap = (HashMap) JSONUtilities.parse(jsonString5);
                System.out.println(parseMap);
                parseMap = (HashMap) JSONUtilities.parse(jsonString6);
                System.out.println(parseMap);
                System.out.println("\n\n");

                //Happy Paths
                Iterator it = jsonMap.entrySet().iterator();
                while (it.hasNext())
                {
                    Map.Entry pair = (Map.Entry) it.next();
                    System.out.println(pair.getKey() + " = " + pair.getValue());
                }
                System.out.println("Output from the Iterator");
                System.out.println(jsonMap.get("airplaneDesignation"));

                //comapares data

                System.out.println("Is my F-15 the same as all of my other airplanes");
                MilitaryAirplane readObject1 = new MilitaryAirplane(jsonMap);

                System.out.println(readObject1.equals(airplane1));
                System.out.println(readObject1.equals(airplane2));
                System.out.println(readObject1.equals(airplane3));
                System.out.println(readObject1.equals(airplane4));
                System.out.println(readObject1.equals(airplane5));
                System.out.println(readObject1.equals(airplane6));
                System.out.println(readObject1);

                //Nasty Paths
                System.out.println("/************* 'null' nasty path **************/");
                try
                {

                    System.out.println("This is what a 'null' plane looks like");
                    MilitaryAirplane airplane7 = new MilitaryAirplane(null, null, null, null, null, null);
                    jsonOut.writeObject(airplane7);

                    String jsonString7 = JSONUtilities.stringify(airplane7);
                    System.out.println(jsonString7);
                }
                catch (Exception e)
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    System.out.println("Nulls are nasty");
                }

                System.out.println("/*Make a Military plane with a 'empty string' characters NASTY PATH*/");
                try
                {
                    MilitaryAirplane airplane8 = new MilitaryAirplane("", "blah", "", "", "blah2", "");
                    jsonOut.writeObject(airplane8);

                    String jsonString8 = JSONUtilities.stringify(airplane8);
                    System.out.println(jsonString8);

                }
                catch (Exception e)
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    System.out.println("Empty Strings are nasty");
                }

                System.out.println("/*Make a Military plane with a 'newline' character NASTY PATH*/");
                try
                {
                    MilitaryAirplane airplane9 = new MilitaryAirplane("\n", "asdf", "asdf", "asdf", "asdf", "asdf");
                    jsonOut.writeObject(airplane9);

                    String jsonString9 = JSONUtilities.stringify(airplane9);
                    System.out.println(jsonString9);

                }
                catch (Exception e)
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    System.out.println("New line characters are nasty");
                }
                System.out.println("/*************Unwrittable file nasty path**************/");
                try
                {
                    System.out.println("Let's try writting to files that we do not have permission to write to");
                    FileOutputStream unwrittableOutputStream = new FileOutputStream(unwrittableFile);
                    JSONOutputStream unwrittableJSONoutStream = new JSONOutputStream(unwrittableOutputStream);


                    // writes objects into a file
                    unwrittableJSONoutStream.writeObject(airplane1);
                    unwrittableJSONoutStream.writeObject(airplane2);
                    unwrittableJSONoutStream.writeObject(airplane3);
                    unwrittableJSONoutStream.writeObject(airplane4);
                    unwrittableJSONoutStream.writeObject(airplane5);
                    unwrittableJSONoutStream.writeObject(airplane6);


                }
                catch (Exception e)
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    e.printStackTrace();
                    System.out.println("Looks like it didn't work");
                }

                try
                {
                    System.out.println("Let's try reading an image");
                    //MilitaryAirplane airplane10 = new MilitaryAirplane();
                    File imageFile = new File("/Users/brian/Desktop/thor.jpg");
                    FileInputStream aImageFileInStream = new FileInputStream(imageFile);
                    JSONInputStream badJsonIn = new JSONInputStream(aImageFileInStream);
                    HashMap badJsonMap = (HashMap)badJsonIn.readObject();

                }
                catch (Exception e)
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    e.printStackTrace();
                    System.out.println("Looks like reading images do not work");
                }

                try
                {
                    System.out.println("Let's try reading a nonexistant file");
                    File blankFile = new File("/Users/brian/Desktop/blank.jpg");
                    FileInputStream aImageFileInStream = new FileInputStream(blankFile);
                    JSONInputStream badJsonIn = new JSONInputStream(aImageFileInStream);
                    HashMap blankJsonMap = (HashMap)badJsonIn.readObject();

                }
                catch (Exception e)
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    e.printStackTrace();
                    System.out.println("Looks like reading non existant files do not work");
                }

                try
                {
                    System.out.println("Let's try reading a unreadable file");
                    File unreadableFile = new File("/Users/brian/Desktop/unwriteableJSONfile.jpg");
                    FileInputStream aImageFileInStream = new FileInputStream(unreadableFile);
                    JSONInputStream badJsonIn = new JSONInputStream(aImageFileInStream);
                    HashMap blankJsonMap = (HashMap)badJsonIn.readObject();

                }
                catch (Exception e)
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    e.printStackTrace();
                    System.out.println("Looks like reading non readable file does not work");
                }

                System.out.println("\n" +"/* Read garbage data Nasty Path */");
                try
                {
                    String plane11 = "{" +
                            "\"airplaneName\":\"Falcon\"," +
                            "\"airplaneType\":\"Fighter\",*&#&*&(#@*($&#@$Garbage Random0987654321";
                    HashMap parseMap11 = (HashMap) JSONUtilities.parse(plane11);
                    System.out.println(parseMap11);
                }
                catch (Exception e)
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    e.printStackTrace();
                    System.out.println("Random garbage text does not work as a JSON string");
                }

                try
                {
                    MilitaryAirplane airplane12 = new MilitaryAirplane(null, null, null, null, null, null);
                    System.out.println("This is my null object airplane12");
                    String nullAirplane12 = JSONUtilities.stringify(airplane12);
                    System.out.println("This is my null airplane13");
                    String randomAirplane13 = JSONUtilities.stringify(null);
                    System.out.println(nullAirplane12);



                }
                catch (Exception e)
                {
                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                    e.printStackTrace();
                    System.out.println("I just tried to stringify a null airplane");
                }

            }
            catch (JSONException e)
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                e.printStackTrace();
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
    }

}
