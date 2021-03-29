package seedu.duke.utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import seedu.duke.email.Archive;
import seedu.duke.email.Deleted;
import seedu.duke.email.Draft;
import seedu.duke.email.Email;
import seedu.duke.email.Inbox;
import seedu.duke.email.Junk;
import seedu.duke.email.Sent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Storage {
    private String fileName;
    private String filePath;
    private String pwd;
    private String emailAccount;

    public String getEmailAccount() {
        return emailAccount;
    }

    public String getPwd() {
        return pwd;
    }

    public Storage(String fileName, String account) {
        this.fileName = fileName;
        this.filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + fileName;
        this.pwd = "";
        this.emailAccount = account;
    }

    public Storage() {
        this.fileName = null;
        this.filePath = null;
        this.pwd = null;
        this.emailAccount = null;

    }

    public ArrayList<Email> load() throws IOException, ParseException {
        try {
            JSONObject accountInfo = readJson();
            pwd = getPassword(accountInfo);
            ArrayList<Email> emailList = parse(accountInfo);
            return emailList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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
        File file = new File(filePath);
        if (!file.exists()) {
            createJsonFile(file);
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
                    Inbox inboxEmail = new Inbox(e.get("from").toString(),
                            Parser.parseRecipients(e.get("to").toString()),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(inboxEmail);
                    break;
                case "drafts":
                    Draft draftEmail = new Draft(e.get("from").toString(),
                            Parser.parseRecipients(e.get("to").toString()),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(draftEmail);
                    break;
                case "archive":
                    Archive archiveEmail = new Archive(e.get("from").toString(),
                            Parser.parseRecipients(e.get("to").toString()),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(archiveEmail);
                    break;
                case "sent":
                    Sent sentEmail = new Sent(e.get("from").toString(), Parser.parseRecipients(e.get("to").toString()),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(sentEmail);
                    break;
                case "deleted":
                    Deleted deletedEmail = new Deleted(e.get("from").toString(),
                            Parser.parseRecipients(e.get("to").toString()),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(deletedEmail);
                    break;
                case "junk":
                    Junk junkEmail = new Junk(e.get("from").toString(), Parser.parseRecipients(e.get("to").toString()),
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

    public String getPassword(JSONObject jsonObject) {
        return (String) jsonObject.get("password");
    }

    public void changePwd(String newPassword) {
        pwd = newPassword;
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            jsonObject.put("password", newPassword);

            FileWriter file = new FileWriter(filePath);
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    private void createJsonFile(File file) {
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(filePath);
            fw.write("{}");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
