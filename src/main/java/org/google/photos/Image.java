package org.google.photos;

import java.util.Date;

import lombok.Data;

@Data
public class Image {
	String url;
	String name;
	Date uploadedOn;
}
