package workshop.testing.ui.main;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import workshop.testing.R;
import workshop.testing.data.local.RecipeStore;
import workshop.testing.data.model.Recipe;
import workshop.testing.ui.recipe.RecipeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recipes);
        final RecipeStore store = new RecipeStore(this, "recipes");
        RecipeAdapter adapter = new RecipeAdapter(store);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button btnDelete = (Button) findViewById(R.id.btnRandom);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                int randomPosition = ThreadLocalRandom.current().nextInt(0, store.getCountRecipes());
                Log.d("random", "onClick: " + randomPosition);

                Recipe recipe = store.recipes.get(randomPosition);

                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
                intent.putExtra(RecipeActivity.KEY_ID, recipe.id);
                startActivity(intent);
            }
        });

    }

}
