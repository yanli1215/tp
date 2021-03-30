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

    public Storage(String fileName, String account, String pwd) {
        this.fileName = fileName;
        this.filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + fileName;
        this.pwd = pwd;
        this.emailAccount = account;
    }

    public Storage() {
        this.fileName = null;
        this.filePath = null;
        this.pwd = null;
        this.emailAccount = null;

    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public String getPwd() {
        return pwd;
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
                            getToArrayList((JSONArray) e.get("to")),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(inboxEmail);
                    break;
                case "drafts":
                    Draft draftEmail = new Draft(e.get("from").toString(),
                            getToArrayList((JSONArray) e.get("to")),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(draftEmail);
                    break;
                case "archive":
                    Archive archiveEmail = new Archive(e.get("from").toString(),
                            getToArrayList((JSONArray) e.get("to")),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(archiveEmail);
                    break;
                case "sent":
                    Sent sentEmail = new Sent(e.get("from").toString(), getToArrayList((JSONArray) e.get("to")),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(sentEmail);
                    break;
                case "deleted":
                    Deleted deletedEmail = new Deleted(e.get("from").toString(),
                            getToArrayList((JSONArray) e.get("to")),
                            e.get("subject").toString(), e.get("time").toString(), e.get("content").toString());
                    allEmails.add(deletedEmail);
                    break;
                case "junk":

                    Junk junkEmail = new Junk(e.get("from").toString(), getToArrayList((JSONArray) e.get("to")),
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

    private ArrayList<String> getToArrayList(JSONArray toList) {
        ArrayList<String> toArrayList = new ArrayList<>();
        for (int i = 0; i < toList.size(); i++) {
            String to = (String) toList.get(i);
            toArrayList.add(to);
        }
        return toArrayList;
    }

    public String getPassword(JSONObject jsonObject) {
        return (String) jsonObject.get("password");
    }

    public void changePwd(String newPassword) {
        pwd = newPassword;
        updateEmails("password", newPassword);
    }

    public void updateAllTypeEmails(ArrayList<Email> emails) {
        JSONArray inboxList = new JSONArray();
        JSONArray deletedList = new JSONArray();
        JSONArray junkList = new JSONArray();
        JSONArray archiveList = new JSONArray();
        JSONArray sentList = new JSONArray();
        JSONArray draftList = new JSONArray();

        for (Email email: emails) {
            if (email instanceof Inbox) {
                inboxList.add(createJsonObj(email));
            }
            if (email instanceof Deleted) {
                deletedList.add(createJsonObj(email));
            }
            if (email instanceof Junk) {
                junkList.add(createJsonObj(email));
            }
            if (email instanceof Archive) {
                archiveList.add(createJsonObj(email));
            }
            if (email instanceof Sent) {
                sentList.add(createJsonObj(email));
            }
            if (email instanceof Draft) {
                draftList.add(createJsonObj(email));
            }
        }
        updateEmails("inbox", inboxList);
        updateEmails("deleted", deletedList);
        updateEmails("junk", junkList);
        updateEmails("archive", archiveList);
        updateEmails("sent", sentList);
        updateEmails("drafts", draftList);
    }

    private JSONObject createJsonObj(Email email) {
        JSONObject emailObj = new JSONObject();
        JSONArray toList = new JSONArray();

        emailObj.put("subject", email.getSubject());
        emailObj.put("from", email.getFrom());
        for (String to: email.getTo()) {
            toList.add(to);
        }
        emailObj.put("to", toList);
        emailObj.put("time", email.getTime());
        emailObj.put("content", email.getContent());
        return emailObj;
    }

    private <T> void updateEmails(String key, T newValue) {
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            jsonObject.put(key, newValue);
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

    /**
     * create a json file with the skeleton as content for new users
     */
    private void createJsonFile(File file) {
        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(filePath);
            JSONObject js = new JSONObject();
            JSONArray inboxList = new JSONArray();
            JSONArray deletedList = new JSONArray();
            JSONArray junkList = new JSONArray();
            JSONArray archiveList = new JSONArray();
            JSONArray sentList = new JSONArray();
            JSONArray draftList = new JSONArray();
            js.put("account", emailAccount);
            js.put("password", pwd);
            js.put("inbox", inboxList);
            js.put("deleted", deletedList);
            js.put("junk", junkList);
            js.put("archive", archiveList);
            js.put("sent", sentList);
            js.put("drafts", draftList);
            fw.write(js.toJSONString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
