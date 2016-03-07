package example.kagan.ara;

/**
 * Created by kagan on 12.02.2016.
 */
public class DPuser {
    private String studentnickname;
    private String studentpassword;

    public String getStudentnickname() {
        return studentnickname;
    }

    public void setStudentnickname(String studentnickname) {
        this.studentnickname = studentnickname;
    }

    public String getStudentpassword() {
        return studentpassword;
    }

    public void setStudentpassword(String studentpassword) {
        this.studentpassword = studentpassword;
    }

    public DPuser(String studentnickname, String studentpassword)
    {
        this.studentnickname = studentnickname;
        this.studentpassword = studentpassword;



    }
}
