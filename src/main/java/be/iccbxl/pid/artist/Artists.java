package be.iccbxl.pid.artist;

import java.util.ArrayList;
import java.util.Collection;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//Class to store the list of
//all the artists in an
//Array List
@JacksonXmlRootElement
public class Artists {

    @JacksonXmlProperty(localName = "Artist")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Collection<Artist> artists = null;

    public Collection<Artist> getArtists() {
        if (artists == null) {

            artists = new ArrayList<>();

        }

        return artists;

    }

    public void setArtists(Collection<Artist> collection) {
        this.artists = collection;
    }
}