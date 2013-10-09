package com.linkeo.util.color;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ColorFormat {
	public static Color decode(String str){
		for(ColorFormat format: COLOR_FORMATS){
			Color color = format.parseColor(str);
			if(color!=null)
				return color;
		}
		return null;
	}
	
	private static ColorFormat[] COLOR_FORMATS={
		new ColorFormat(
				"#?([0-9A-F]{2})([0-9A-F]{2})([0-9A-F]{2})([0-9A-F]{2})",
				255) {@Override public int parseInt(String str) {
				return Integer.decode("0x"+str);
			}
		},
		new ColorFormat(
				"#?([0-9A-F]{2})([0-9A-F]{2})([0-9A-F]{2})",
				255) {@Override public int parseInt(String str) {
				return Integer.decode("0x"+str);
			}
		},
		new ColorFormat(
				"#?([0-9A-F])([0-9A-F])([0-9A-F])([0-9A-F])",
				15) {@Override public int parseInt(String str) {
				return Integer.decode("0x"+str);
			}
		},
		new ColorFormat(
				"#?([0-9A-F])([0-9A-F])([0-9A-F])",
				15) {@Override public int parseInt(String str) {
				return Integer.decode("0x"+str);
			}
		},
		new ColorFormat(
				"\\W?(\\d{1,3})\\W+(\\d{1,3})\\W+(\\d{1,3})\\W+(\\d{1,3})\\W?",
				255) {@Override public int parseInt(String str) {
				return Integer.decode(str);
			}
		},
		new ColorFormat(
				"\\W?(\\d{1,3})\\W+(\\d{1,3})\\W+(\\d{1,3})\\W?",
				255) {@Override public int parseInt(String str) {
				return Integer.decode(str);
			}
		}
	};
	
	public abstract int parseInt(String str);
	protected ColorFormat(String regex, int power) {
		this.pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		this.power = power;
	}
	public Color parseColor(String str){
		Matcher m = pattern.matcher(str);
		boolean hasalpha = true;
		int r=0,g=0,b=0,a=255;
		if(m.matches()){
			int groupCnt = m.groupCount();
			if(groupCnt==3){
				hasalpha = false;
				r=(int) (255.0*parseInt(m.group(1))/power);
				g=(int) (255.0*parseInt(m.group(2))/power);
				b=(int) (255.0*parseInt(m.group(3))/power);
			}else if(groupCnt==4){
				a=(int) (255.0*parseInt(m.group(1))/power);
				r=(int) (255.0*parseInt(m.group(2))/power);
				g=(int) (255.0*parseInt(m.group(3))/power);
				b=(int) (255.0*parseInt(m.group(4))/power);
			}
			int rgba = a*0x1000000+r*0x10000+g*0x100+b;
			Color color = new Color(rgba, hasalpha);
			return color;
		}else
			return null;
	}
	Pattern pattern;
	int power;
}
