package FURAMA_RESORT_PROJECT.models;

import java.util.Objects;

public class Booking implements Comparable<Booking> {
    public static int increseValue=1000;
    private int bookingCode;
    private String beginDate;
    private String endDate;
    private int MKH;
    private String typeService;
    private String nameService;
    private String typeRent;

    public Booking(String beginDate, String endDate, int MKH,String typeService, String nameService) {
        this.bookingCode =increseValue++;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.MKH=MKH;
        this.typeService = typeService;
        this.nameService = nameService;

    }

    @Override
    public int compareTo(Booking b) {
        if (beginDate.equals(b.beginDate)) return endDate.compareTo(b.endDate) > 0 ? 1 : -1;
        else
            return beginDate.compareTo(b.beginDate) > 0 ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode=" + bookingCode +
                ", beginDate='" + beginDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", typeService='" + typeService + '\'' +
                ", nameService='" + nameService + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(beginDate, booking.beginDate) && Objects.equals(endDate, booking.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beginDate, endDate);
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getMKH() {
        return MKH;
    }

    public void setMKH(int MKH) {
        this.MKH = MKH;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }
}
