package noteKeeperApp;

import java.util.ArrayList;
import java.util.List;

public class User {

    // junit annotations @runwith @test
    // assertion
    private int uid;
    private String name;
//    private String password;

    private List<Note> notes = new ArrayList<>();

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(int id,String title,String content) {
        Note n=new Note(id,title,content);
        notes.add(n);
    }

    public void deleteNote(int id){
        int size = notes.size();
        for(int i=0;i<size;i++){
            if(notes.get(i).getId() == id){
                notes.remove(i);
            }
        }
    }

    public void edit(int n,int id,String[] details){
        Note nn = null;
        for(Note note:notes){
            if(note.getId() == id){
                nn = note;
            }
        }
        if(nn == null){
            return;
        }
        if( n==1 || n==3){
            nn.setTitle(details[0]);
        }
        if( n== 2 || n == 3){
            nn.setContent(details[1]);

        }
    }
}
