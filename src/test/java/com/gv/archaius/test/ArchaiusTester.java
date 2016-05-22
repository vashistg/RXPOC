package com.gv.archaius.test;

import java.util.Collections;

import javax.swing.SpringLayout.Constraints;

import org.junit.Test;
import static org.junit.Assert.*;
import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringListProperty;
import com.netflix.config.DynamicStringMapProperty;
import com.netflix.config.DynamicStringProperty;

public class ArchaiusTester {

	/*@Test
	public void testBasicStringProps() {
	    DynamicStringProperty sampleProp = DynamicPropertyFactory.getInstance().getStringProperty("stringprop", "");
	    DynamicStringListProperty listProperty = new DynamicStringListProperty("listprop", Collections.emptyList());
	    DynamicStringMapProperty mapProperty = new DynamicStringMapProperty("mapprop", Collections.emptyMap());
	    
	    assertEquals(sampleProp.get(), "propvalue");
	}*/

	/*@Test
	public void testBasicListProps() {
	    DynamicStringListProperty listProperty = new DynamicStringListProperty("listprop", Collections.emptyList());
	    assertThat(listProperty.get(), ("value1", "value2", "value3"));
	}

	@Test
	public void testBasicMapProps() {
	    DynamicStringMapProperty mapProperty = new DynamicStringMapProperty("mapprop", Collections.emptyMap());
	    assertThat(mapProperty.getMap(), allOf(hasEntry("key1", "value1"), hasEntry("key2", "value2")));
	}

	@Test
	public void testBasicLongProperty() {
	    DynamicLongProperty longProp = DynamicPropertyFactory.getInstance().getLongProperty("longprop", 1000);
	    assertThat(longProp.get(), equalTo(100L));
	}*/
	
	
	
}
