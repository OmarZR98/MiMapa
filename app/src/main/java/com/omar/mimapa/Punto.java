package com.omar.mimapa;

import android.os.Parcel;
import android.os.Parcelable;

public class Punto implements Parcelable {

    private String latitudInicial;
    private String longitudInicial;
    private String latitudFinal;
    private String longitudFinal;

    public String getLatitudInicial() {
        return latitudInicial;
    }

    public void setLatitudInicial(String latitudInicial) {
        this.latitudInicial = latitudInicial;
    }

    public String getLongitudInicial() {
        return longitudInicial;
    }

    public void setLongitudInicial(String longitudInicial) {
        this.longitudInicial = longitudInicial;
    }

    public String getLatitudFinal() {
        return latitudFinal;
    }

    public void setLatitudFinal(String latitudFinal) {
        this.latitudFinal = latitudFinal;
    }

    public String getLongitudFinal() {
        return longitudFinal;
    }

    public void setLongitudFinal(String longitudFinal) {
        this.longitudFinal = longitudFinal;
    }

    protected Punto(Parcel in) {
        this.longitudInicial=in.readString();
        this.latitudInicial=in.readString();
        this.longitudFinal=in.readString();
        this.latitudFinal=in.readString();
    }

    public static final Creator<Punto> CREATOR = new Creator<Punto>() {
        @Override
        public Punto createFromParcel(Parcel in) {
            return new Punto(in);
        }

        @Override
        public Punto[] newArray(int size) {
            return new Punto[size];
        }
    };

    public Punto() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(longitudInicial);
        parcel.writeString(latitudInicial);
        parcel.writeString(longitudFinal);
        parcel.writeString(latitudFinal);

    }
    private void readFromParcel(Parcel in){

        longitudInicial=in.readString();
        latitudInicial=in.readString();
        longitudFinal=in.readString();
        latitudFinal=in.readString();
    }
}
