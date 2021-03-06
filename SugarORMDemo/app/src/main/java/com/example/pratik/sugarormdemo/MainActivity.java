package com.example.pratik.sugarormdemo;

import android.app.admin.DevicePolicyManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Status status;
    private View v1, v2, v3, v4;
    DevicePolicyManager mDPM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.rlFragment, TestFragment.newInstance()).addToBackStack(null);
        transaction.commit();

        /*checkProgressBar();

        setSupportActionBar(toolbar);

        checkSugarOrm();

        checkSnappyDB();

*/

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkLockScreen();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                startActivity(new Intent(MainActivity.this,SnappyDB.class));
            }
        });*/
    }

    public void checkLockScreen() {
        Window window = this.getWindow();
        window.addFlags(LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(LayoutParams.FLAG_TURN_SCREEN_ON);
//        mDPM = (DevicePolicyManager) getSystemService(getBaseContext().DEVICE_POLICY_SERVICE);
        mDPM = (DevicePolicyManager) getSystemService(getBaseContext().DEVICE_POLICY_SERVICE);
//        mDPM.lockNow();
    }


    public void checkProgressBar() {
        v1 = (View) findViewById(R.id.v1);
        v2 = (View) findViewById(R.id.v2);

        v3 = (View) findViewById(R.id.v3);

        v4 = (View) findViewById(R.id.v4);

        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) v1.getLayoutParams();

        params1.weight = 25f;

        LinearLayout.LayoutParams params2 = (LinearLayout.LayoutParams) v2.getLayoutParams();

        params2.weight = 25f;
        LinearLayout.LayoutParams params3 = (LinearLayout.LayoutParams) v3.getLayoutParams();

        params3.weight = 25f;

        LinearLayout.LayoutParams params4 = (LinearLayout.LayoutParams) v4.getLayoutParams();

        params4.weight = 25f;


    }

    public void checkSnappyDB() {
        try {
            DB snappydb = DBFactory.open(this);
            snappydb.put("name", "Jack Reacher");
            snappydb.putInt("age", 42);
            snappydb.putBoolean("single", true);
            snappydb.put("books", new String[]{"One Shot", "Tripwire", "61 Hours"});

            status = new Status();
            status.setMessage("Hii");
            status.setStatus("true");

            snappydb.put("status", status);

            snappydb.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    public void checkSugarOrm() {
        List<Book> books = new ArrayList<Book>();
        Book book = new Book();

        Book.deleteAll(Book.class);

        for (int i = 0; i < 10; i++) {
            book = new Book(i + "", i + 5 + "");
            book.save();
            System.out.println("title --" + book.title);
            System.out.println("edition --" + book.edition);
            System.out.print("Id ---" + book.getId());
        }

        books = Book.listAll(Book.class);

        System.out.println("size --" + books.size());


        ArrayList<Book> newbook = (ArrayList<Book>) Book.find(Book.class, "title = ? or edition = ?", "1", "8");
        newbook.get(0).title = "Yooo";
        newbook.get(1).title = "Yooo";

        String title = "Yooo";
        newbook.get(0).edition = "New";
        newbook.get(1).edition = "New";
        newbook.get(0).save();
        newbook.get(1).save();
        books.add(newbook.get(0));

        System.out.println("size --" + books.size());

        books = Book.listAll(Book.class);

        for (int i = 0; i < books.size(); i++) {

            book = books.get(i);
            System.out.println("title --" + book.title);
            System.out.println("edition --" + book.edition);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
