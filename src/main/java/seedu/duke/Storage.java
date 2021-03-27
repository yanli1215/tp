package seedu.duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import seedu.duke.email.Email;
import seedu.duke.email.Archive;
import seedu.duke.email.Draft;
import seedu.duke.email.Deleted;
import seedu.duke.email.Inbox;
import seedu.duke.email.Junk;
import seedu.duke.email.Sent;

public class Storage {
    private String fileName;
    private String filePath;

    public Storage(String fileName) {
        this.fileName = fileName;
        this.filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + fileName;

    }

    public Storage() {
        this.fileName = null;
        this.filePath = null;

    }

   /* public void getListOfJsonFiles(){
        List<String> listOfJsonFiles = new ArrayList<String>();
        String localDir = System.getProperty("user.dir");
        Path dirPath = Paths.get(localDir, "data");
        File dir = new File(String.valueOf(dirPath));
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((".json"))) {
                listOfJsonFiles.add(file.getName());
            }
        }
        System.out.println(listOfJsonFiles);
    }*/


    public ArrayList<Email> load() throws IOException, ParseException {
        JSONObject accountInfo = readJson();
        ArrayList<Email> emailList = parse(accountInfo);
        return emailList;
    }

    public JSONObject readJson() throws IOException, ParseException {
        String localDir = System.getProperty("user.dir");
        Path dirPath = Paths.get(localDir, "data");
        if (!Files.exists(dirPath)) {
            try {
                Files.createDirectory(dirPath);
            } catch (IOException e) {
                System.err.println("Failed to create directory 'data'!" + e.getMessage());
            }
        }

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filePath));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }

    public ArrayList<Email> parse(JSONObject jsonObject) {
        ArrayList<Email> allEmails = new ArrayList<>();
        ArrayList<String> emailType = new ArrayList<>();
        for (Object key : jsonObject.keySet()) {
            if (!key.toString().equals("account") && !key.toString().equals("password")) {
                emailType.add(key.toString());
            }
        }
        for (String type : emailType) {
            JSONArray companyList = (JSONArray) jsonObject.get(type);
            Iterator<JSONObject> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                Map e = iterator.next();
                switch (type) {
                case "inbox":
                    Inbox inboxEmail = new Inbox(e.get("from").toString(), e.get("to").toString(),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(inboxEmail);
                    break;
                case "drafts":
                    Draft draftEmail = new Draft(e.get("from").toString(), e.get("to").toString(),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(draftEmail);
                    break;
                case "archive":
                    Archive archiveEmail = new Archive(e.get("from").toString(), e.get("to").toString(),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(archiveEmail);
                    break;
                case "sent":
                    Sent sentEmail = new Sent(e.get("from").toString(), e.get("to").toString(),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(sentEmail);
                    break;
                case "deleted":
                    Deleted deletedEmail = new Deleted(e.get("from").toString(), e.get("to").toString(),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(deletedEmail);
                    break;
                case "junk":
                    Junk junkEmail = new Junk(e.get("from").toString(), e.get("to").toString(),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(junkEmail);
                    break;
                default:
                    break;
                }

            }
        }
        return allEmails;
    }



}
