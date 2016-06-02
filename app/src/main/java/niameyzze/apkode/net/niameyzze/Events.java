package niameyzze.apkode.net.niameyzze;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import niameyzze.apkode.net.niameyzze.evenement.EvenementAdapter;
import niameyzze.apkode.net.niameyzze.evenement.EvenementObject;

public class Events extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(mSectionsPagerAdapter.getTabView(i));
        }

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private RecyclerView recyclerView;
        private List<EvenementObject> evenementObjects1 = new ArrayList<>();
        private List<EvenementObject> evenementObjects2 = new ArrayList<>();
        private List<EvenementObject> evenementObjects3 = new ArrayList<>();
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_events, container, false);

            getDataFromApi(rootView);

            recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    recyclerView.setAdapter(new EvenementAdapter(evenementObjects1));
                    break;
                case 2:
                    recyclerView.setAdapter(new EvenementAdapter(evenementObjects2));
                    break;
                case 3:
                    recyclerView.setAdapter(new EvenementAdapter(evenementObjects3));
                    break;

            }

            return rootView;
        }

        private void getDataFromApi(View rootView) {
            ProgressBar loading = (ProgressBar) rootView.findViewById(R.id.loading);
            loading.setVisibility(View.GONE);
            evenementObjects1.add(new EvenementObject("Culture", "Musique", "Vernissable album dido", "gratuit", "Palais des congrès", "Une longue présetation du concert de vernissage de l'artiste venu de l'angleterre Dido qui a chanté avec eminem slim shaddy", "http://i.imgur.com/DvpvklR.png", "01/02/2016"));
            evenementObjects1.add(new EvenementObject("Culture", "Musique", "Vernissable album dido", "gratuit", "Palais des congrès", "Une longue présetation du concert de vernissage de l'artiste venu de l'angleterre Dido qui a chanté avec eminem slim shaddy", "http://i.imgur.com/DvpvklR.png", "01/02/2016"));
            evenementObjects1.add(new EvenementObject("Culture", "Musique", "Vernissable album dido", "gratuit", "Palais des congrès", "Une longue présetation du concert de vernissage de l'artiste venu de l'angleterre Dido qui a chanté avec eminem slim shaddy", "http://i.imgur.com/DvpvklR.png", "01/02/2016"));
            evenementObjects1.add(new EvenementObject("Culture", "Musique", "Vernissable album dido", "gratuit", "Palais des congrès", "Une longue présetation du concert de vernissage de l'artiste venu de l'angleterre Dido qui a chanté avec eminem slim shaddy", "http://i.imgur.com/DvpvklR.png", "01/02/2016"));
            evenementObjects1.add(new EvenementObject("Culture", "Musique", "Vernissable album dido", "gratuit", "Palais des congrès", "Une longue présetation du concert de vernissage de l'artiste venu de l'angleterre Dido qui a chanté avec eminem slim shaddy", "http://i.imgur.com/DvpvklR.png", "01/02/2016"));


            evenementObjects2.add(new EvenementObject("Education", "Formation", "Vernissable album dido", "gratuit", "Palais des congrès", "Une longue présetation du concert de vernissage de l'artiste venu de l'angleterre Dido qui a chanté avec eminem slim shaddy", "http://i.imgur.com/DvpvklR.png", "15/05/2016"));
            evenementObjects3.add(new EvenementObject("Sport", "Football", "Vernissable album dido", "gratuit", "Palais des congrès", "Une longue présetation du concert de vernissage de l'artiste venu de l'angleterre Dido qui a chanté avec eminem slim shaddy", "http://i.imgur.com/DvpvklR.png", "22/06/2016"));

        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        int icons[] = {R.mipmap.ic_culture, R.mipmap.ic_education, R.mipmap.ic_sport};
       // private String title[] = new String[]{"Tab1", "Tab2", "Tab3"};

        public View getTabView(int position) {
            // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_view, null);

           // TextView tv = (TextView) v.findViewById(R.id.tabText);
            //tv.setText(title[position]);

            ImageView img = (ImageView) v.findViewById(R.id.tabImage);
            img.setImageResource(icons[position]);
            return v;
        }


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            Drawable drawable = getResources().getDrawable(icons[position]);
            ImageSpan imageSpan = new ImageSpan(drawable);
            SpannableString spannableString = new SpannableString("");

            spannableString.setSpan(imageSpan, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            return spannableString;
        }
    }
}
