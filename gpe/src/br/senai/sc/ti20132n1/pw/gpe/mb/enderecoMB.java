package br.senai.sc.ti20132n1.pw.gpe.mb;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class enderecoMB {
	private String latitude;
	private String longitude;
	
	public String getLatitude() {
		if(latitude == null){
			latitude = "-25";
		}
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		if(longitude == null){
			longitude = "-51.6588";
		}
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
