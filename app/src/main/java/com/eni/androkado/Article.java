package com.eni.androkado;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by quentin for AndroKado on 05/03/2019.
 */
public class Article implements Parcelable {
    private String nom;
    private String description;
    private float prix;
    private int envie;
    private String url;
    private boolean achete;

    public Article(String nom, String description, float prix, int envie, String url, boolean achete) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.envie = envie;
        this.url = url;
        this.achete = achete;
    }

    protected Article(Parcel in) {
        nom = in.readString();
        description = in.readString();
        prix = in.readFloat();
        envie = in.readInt();
        url = in.readString();
        achete = in.readByte() != 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getEnvie() {
        return envie;
    }

    public void setEnvie(int envie) {
        this.envie = envie;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAchete() {
        return achete;
    }

    public void setAchete(boolean achete) {
        this.achete = achete;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(description);
        dest.writeFloat(prix);
        dest.writeInt(envie);
        dest.writeString(url);
        dest.writeByte((byte) (achete ? 1 : 0));
    }
}
