package util;

public class StringToArrayUtils {
    public static int[] getVipSeats(String seats){
        String[] vipSeats = seats.split(",");
        int [] vipSeatsInt = new int[vipSeats.length];
        for(int i = 0; i< vipSeats.length; i++){
            vipSeatsInt[i] = Integer.valueOf(vipSeats[i].trim());
        }
        return vipSeatsInt;
    }
}
