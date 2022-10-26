package com.example.music;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MegaVoice extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);


        // Create an array of amiwos.
        ArrayList<Amiwo> amiwos = new ArrayList<Amiwo>();

        // Adding amiwos to an array.
        amiwos.add(new Amiwo("Brahms", "Symphony No.4 in E minor"));
        amiwos.add(new Amiwo("Brahms", "Symphony No.4 in E minor"));
        amiwos.add(new Amiwo("Liszt", "Transcendental Étude no.04 \"Mazeppa\""));
        amiwos.add(new Amiwo("Liszt", "Liebestraum No. 3, Notturno"));
        amiwos.add(new Amiwo("Chopin", "Nocturne op.9 No.2"));
        amiwos.add(new Amiwo("Chopin", "Etude in E minor, Op. 25, No. 5"));
        amiwos.add(new Amiwo("Schubert", "Piano Sonata No.13 in A-dur"));
        amiwos.add(new Amiwo("Schubert", "Impromptu Op.90 No.4 in A-flat major"));
        amiwos.add(new Amiwo("Viardot", "\"Haí Lulí\""));
        amiwos.add(new Amiwo("Schumann", "Concerto for Violoncello and Orchestra A minor"));
        amiwos.add(new Amiwo("Delibes", "Lakmé - Flower Duet"));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        AmiwoAdapter adapter = new AmiwoAdapter(this, amiwos);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // play_list file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlayerActivity
        listView.setOnItemClickListener(this);
    }

    /**
     * Method to identify ListView item clicked and launch PlayerActivity
     */
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        // Get the selected amiwo.
        Amiwo currentAmiwo = (Amiwo) adapterView.getItemAtPosition(position);

        // Extract strings from Opus object.
        String amiwoForPlaying = currentAmiwo.getAmiwo();
        String composerForPlaying = currentAmiwo.getNameOfComposer();

        // Sending the name of composer and his opus to PlayerActivity.
        Intent amiwoIntent = new Intent(this, PlayerActivity.class);
        amiwoIntent.putExtra("amiwo", amiwoForPlaying);
        amiwoIntent.putExtra("composer", composerForPlaying);
        startActivity(amiwoIntent);
    }
}
