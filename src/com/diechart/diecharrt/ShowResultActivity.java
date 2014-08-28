package com.diechart.diecharrt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.diechart.adapter.ListAdapter;
import com.diechart.database.DatabaseHandler;

import android.app.Activity;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowResultActivity extends Activity {
	ListAdapter listAdapter;
	ListView expListView;
	HashMap<String, List<String>> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	private List<JSONObject> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showactivity_layout);
		// get the listview

		expListView = (ListView) findViewById(R.id.listView1);
		DatabaseHandler db = new DatabaseHandler(getApplicationContext());
		String result = db.fetchAllrow();
		try {
			populatelist(new JSONArray(result));
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		listAdapter = new ListAdapter(this, list);

		// setting list adapter
		expListView.setAdapter(listAdapter);
	}

	private void populatelist(JSONArray jArray2) {
		// TODO Auto-generated method stub
		list = new ArrayList<JSONObject>();
		for (int i = 0; i < jArray2.length(); i++) {
			JSONObject j = null;
			try {
				j = jArray2.getJSONObject(i);
				list.add(j);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
