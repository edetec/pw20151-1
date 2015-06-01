package br.senai.sc.ti20132n1.pw.gpe.mb;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class enderecoMB {
	private String latitude = "-25";
	private String longitude = "-51.6588";
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String save(){
		System.out.println("Latitude: " + latitude);
		System.out.println("Longitude: " + longitude);
		return "";
	}
}
