package com.Ex.JUNIT;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import SimpleMerge.SimpleMergeFrame;

public class SimpleMergeTest {

	private SimpleMergeFrame sf;
	
	@Test
	public void testCreateFrame() {
		Assert.assertNotNull(SimpleMergeFrame.createFrame());
	}

	@Test
	public void testGetLeftLoadBtn() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getLeftLoadBtn());
	}

	@Test
	public void testGetRightLoadBtn() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getRightLoadBtn());
	}

	@Test
	public void testGetEditBtn() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getEditBtn());
	}

	@Test
	public void testGetsaveCBox() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getsaveCBox());
	}

	@Test
	public void testGetSaveBtn() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getSaveBtn());
	}

	@Test
	public void testGetCpyToRightBtn() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getCpyToRightBtn());
	}

	@Test
	public void testGetCpyToLeftBtn() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getCpyToLeftBtn());
	}

	@Test
	public void testGetCompBtn() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getCompBtn());
	}

	@Test
	public void testGetLeftTextArea() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getLeftTextArea());
	}

	@Test
	public void testGetRightTextArea() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getRightTextArea());
	}
	
	@Test
	public void testGetAllCpyToLeftBtn() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getAllCpyToLeftBtn());
	}
	
	@Test
	public void testGetAllCpyToRightBtn() {
		this.sf = SimpleMergeFrame.createFrame();
		Assert.assertNotNull(sf.getAllCpyToRightBtn());
	}
}
