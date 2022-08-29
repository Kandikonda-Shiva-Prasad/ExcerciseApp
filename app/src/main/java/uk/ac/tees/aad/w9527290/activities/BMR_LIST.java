package uk.ac.tees.aad.w9527290.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

import uk.ac.tees.aad.w9527290.Models.Item;
import uk.ac.tees.aad.w9527290.Pattern.Singleton;
import uk.ac.tees.aad.w9527290.R;
import uk.ac.tees.aad.w9527290.adapter.ItemAdapter;

public class BMR_LIST extends AppCompatActivity {

    Button button;
    RecyclerView recyclerView;
    ArrayList<Item> arrayList;
    ItemAdapter adapter;
    Button btn;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_list);

        btn = findViewById(R.id.apirequest);
        editText =findViewById(R.id.searchitem);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getsearch = editText.getText().toString();
                arrayList.clear();
                if(getsearch!=null)
                {
                    Toast.makeText(BMR_LIST.this,getsearch,Toast.LENGTH_LONG).show();
                    String urls = "https://api.edamam.com/api/food-database/v2/parser?app_id=e366011c&app_key=9d76d833c499b2d4cd4921804423dcfc&ingr="+getsearch+"&nutrition-type=cooking";

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urls, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            // Toast.makeText(BMR_LIST.this,response.toString(), Toast.LENGTH_SHORT).show();
                            //



                            try {

                                String FoodName;
                                String Fat;
                                String Cal;
                                String url;
                                JSONArray jsonArray= response.getJSONArray("hints");
                                for (int i =0;i<jsonArray.length();i++)
                                {

                                    JSONObject objects = jsonArray.getJSONObject(i);
                                    JSONObject obj = objects.getJSONObject("food");
                                    JSONObject innerobj = obj.getJSONObject("nutrients");



                                    //Toast.makeText(BMR_LIST.this,obj.toString(),Toast.LENGTH_LONG).show();

                                    FoodName = obj.getString("label");
                                    Fat = innerobj.getString("FAT");
                                    Cal = innerobj.getString("ENERC_KCAL");
                                    url= obj.getString("image");
                                    //    Toast.makeText(BMR_LIST.this,fat,Toast.LENGTH_LONG).show();



                                    //  Toast.makeText(BMR_LIST.this,innerobj.toString(),Toast.LENGTH_LONG).show();


                                    arrayList.add(new Item(url,FoodName,"KAL "+ Cal ,"FAT "+ Fat));

                                    adapter.notifyDataSetChanged();

                                }


















                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            finally {

                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {



                        }


                    });

                    Singleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
                }
            }
        });



         arrayList = new ArrayList<>();
        //arrayList.add(new Item("s","sS","KAL ","FAT "));



         adapter = new ItemAdapter(arrayList,BMR_LIST.this);

        recyclerView = findViewById(R.id.itemrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);









    }
}