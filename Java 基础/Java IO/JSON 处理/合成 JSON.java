package chameleon;

import org.json.*;

public class Account {
	private String ssid;
	private String mac;
	private String psk;
	private JSONObject jb = new JSONObject();
	
	public String getSsid() {
		return ssid;
	}
	
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	
	public String getMac() {
		return mac;
	}
	
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public String getPsk() {
		return psk;
	}
	
	public void setPsk(String psk) {
		this.psk = psk;
	}
	
	public String toString(String mac, String psk) {
		String result = null;
		
		if ((mac != null) && (psk != null)) {
			try {
				jb.put("mac", mac);
				jb.put("psk", psk);
			} catch (Exception e) {
				e.printStackTrace();
			}
			result = jb.toString();
		}
		return result;
	}
}
