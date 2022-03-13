package com.cg.mtb.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Screen {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int screenId;
		private int theatreId;
		private String screenName;
		//private List<Show> show;
		private int rows;
		private int columns;
		
		public Screen() {
			
		}
		

		public Screen(int screenId, int theatreId, String screenName, int rows, int columns) {
			super();
			this.screenId = screenId;
			this.theatreId = theatreId;
			this.screenName = screenName;
			//this.show = show;
			this.rows = rows;
			this.columns = columns;
		}

		public int getScreenId() {
			return screenId;
		}

		public void setScreenId(int screenId) {
			this.screenId = screenId;
		}

		public int getTheatreId() {
			return theatreId;
		}

		public void setTheatreId(int theatreId) {
			this.theatreId = theatreId;
		}

		public String getScreenName() {
			return screenName;
		}

		public void setScreenName(String screenName) {
			this.screenName = screenName;
		}
//
//		public List<Show> getShow() {
//			return show;
//		}
//
//		public void setShow(List<Show> show) {
//			this.show = show;
//		}

		public int getRows() {
			return rows;
		}

		public void setRows(int rows) {
			this.rows = rows;
		}

		public int getColumns() {
			return columns;
		}

		public void setColumns(int columns) {
			this.columns = columns;
		}

		@Override
		public String toString() {
			return "Screen [screenId=" + screenId + ", theatreId=" + theatreId + ", screenName=" + screenName + ", rows="
					+ rows + ", columns=" + columns + "]";
		}
}
