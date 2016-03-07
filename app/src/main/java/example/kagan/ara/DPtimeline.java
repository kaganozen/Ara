package example.kagan.ara;

/**
 * Created by kagan on 22.01.2016.
 */
public class DPtimeline {
    private String name;
    private String idname;
    private String message;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdname() {
        return idname;
    }

    public void setIdname(String idname) {
        this.idname = idname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DPtimeline(String name, String idname, String message)
    {
        this.name = name;
        this.idname = idname;
        this.message = message;

    }
}
