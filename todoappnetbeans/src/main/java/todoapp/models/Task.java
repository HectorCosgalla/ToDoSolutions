package todoapp.models;


public class Task {
    
    private String title;

    private Boolean itsDone;

    public Task(String title){
        this.title = title;
        this.itsDone = false;
    }

    public void setItsDone() {
        this.itsDone = false;
    }

    public Boolean getItsDone() {
        return itsDone;
    }

    public String getTitle() {
        return title;
    }
}
