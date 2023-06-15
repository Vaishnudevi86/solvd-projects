package buildingcompany.exception;

public class MediaRoomException extends Exception {

        public MediaRoomException(String s) {
            super("Incorrect entry for media room.  " +   s);
        }
    }
