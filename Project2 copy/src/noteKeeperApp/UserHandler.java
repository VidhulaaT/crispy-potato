package noteKeeperApp;

import java.util.ArrayList;
import java.util.List;

public class UserHandler {


    // add user
    // delete user
    // login user
    // exit

    List<User> userList = new ArrayList<>();
    User    CurrentUser;
    public User addUser(int id, String name){
        User u = new User();
        u.setUid(id);
        u.setName(name);
        return u;
    }
    public void insertUser(int id,String name){
        User newUser = addUser(id,name);
        userList.add(newUser);

    }
    public boolean deleteUser(int id){
        int size = userList.size();
        boolean flag = false;

        for(int i=0;i<size;i++) {
            if (userList.get(i).getUid() == id) {
                userList.remove(i);
                return true;
            }
        }
        return flag;
    }


    public User userLogin(int id,String name){
        CurrentUser=checkUser(id,name);
        return CurrentUser;
    }



    private User checkUser(int id,String name){

        int size = userList.size();

        for(int i=0;i<size;i++){
            if(userList.get(i).getUid() == id && userList.get(i).getName().equals(name)){
                User u = userList.get(i);
                return u;
            }
        }
        return null;
    }

    public void displayUsers(){
        for(User u:userList){
            System.out.println(u.getUid()+"  "+u.getName());
        }
    }

    public void addNote(int id,String title,String content){
        CurrentUser.setNotes(id,title,content);
    }


    public List<Note> getNotesList(User uu){
        List<Note> notesList = uu.getNotes();
        return notesList;
    }

    public void displayNotes(){
        List<Note> list = getNotesList(CurrentUser);
        for(Note n:list){
            System.out.println(n.getId()+"  "+n.getTitle()+"  "+n.getContent());
        }
    }

    public void delete(int id){
        CurrentUser.deleteNote(id);
    }

    public void edit(int n,int id,String[] details){
        CurrentUser.edit(n,id,details);
    }




}
