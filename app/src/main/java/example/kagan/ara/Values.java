package example.kagan.ara;

/**
 * Created by kagan on 22.01.2016.
 */
public class Values {

    public static abstract class UserMessage
    {
        public static final String TBMESSAGE = "message_TB";
        public static final String MESSAGEID ="message_id";
        public static final String MESSAGEOWNER = "message_owner";
        public static final String MESSAGEOWNERID = "message_owner_id";
        public static final String MESSAGETEXT = "message_text";

    }

    public static abstract class Register
    {
        public static final String TBREGISTER = "register_TB";
        public static final String STUDENTID ="register_id";
        public static final String STUDENTNICKNAME = "register_nickname";
        public static final String STUDENTEMAIL ="register_email";
        public static final String STUDENTPASSWORD = "register_password";
    }
}
