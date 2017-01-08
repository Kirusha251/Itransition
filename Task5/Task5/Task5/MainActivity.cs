using Android.App;
using Android.Widget;
using Android.OS;
using Android.Views;
using Android.Content;
using System.Collections.Generic;
using System.IO;

namespace Task5
{
    [Activity(Label = "Task5", MainLauncher = true, Icon = "@drawable/icon", ScreenOrientation =Android.Content.PM.ScreenOrientation.Portrait)]
    
    public class MainActivity : Activity
    {
        Button createSessionButton;
        ListView sessionList;
        EditText sessionName;
        ArrayAdapter<string> sessionListAdapter;
        List<string> sessions;
        int count = 0;
        
       
        protected override void OnCreate(Bundle bundle)
        {
            base.OnCreate(bundle);
            // Set our view from the "main" layout resource
            SetContentView (Resource.Layout.Main);
            createSessionButton = (Button)FindViewById<Button>(Resource.Id.sessionAtivityButton);
            sessionList = (ListView)FindViewById<ListView>(Resource.Id.sessionList);
            sessionName = (EditText)FindViewById<EditText>(Resource.Id.sessionName);
          
            
            sessions = new List<string>();
            ReadFromFile();
            sessionListAdapter = new ArrayAdapter<string>(this, Android.Resource.Layout.SimpleListItem1,sessions);
            sessionList.Adapter = sessionListAdapter;
            sessionList.ItemClick += SessionList_ItemClick;
            sessionList.ItemLongClick += SessionList_ItemLongClick;
            createSessionButton.Click += delegate
            {
                if (sessionName.Text.ToString().Equals(""))
                {
                    sessions.Add("default" + count);
                    count++;
                }
                else
                {
                    sessions.Add(sessionName.Text.ToString());
                }
                    sessionListAdapter = new ArrayAdapter<string>(this, Android.Resource.Layout.SimpleListItem1, sessions);
                    sessionList.Adapter = sessionListAdapter;
                    sessionList.DeferNotifyDataSetChanged();
                    WriteToFile();
                
            };
            
           
        }

        private void SessionList_ItemLongClick(object sender, AdapterView.ItemLongClickEventArgs e)
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.SetTitle("Delete session " + sessions[e.Position] + "?");
            dialog.SetPositiveButton("Yes", delegate { DeleteSession(e.Position); });
            dialog.SetNegativeButton("No", delegate { });
            dialog.Show();
           

        }
        public void DeleteSession(int position)
        {
            FileInfo file = new FileInfo("/mnt/sdcard/" + sessions[position] + "/");
            if (file.Directory.Exists)
            {

                foreach (FileInfo f in file.Directory.GetFiles())
                {
                    f.Delete();
                }
                file.Directory.Delete();
            }
            sessions.RemoveAt(position);
            sessionListAdapter = new ArrayAdapter<string>(this, Android.Resource.Layout.SimpleListItem1, sessions);
            sessionList.Adapter = sessionListAdapter;
            sessionList.DeferNotifyDataSetChanged();
            WriteToFile();
        }

        private void SessionList_ItemClick(object sender, AdapterView.ItemClickEventArgs e)
        {
            var sessionActivityIntent = new Intent(this, typeof(SessionActivity));
            sessionActivityIntent.PutExtra("currentSession", sessions[e.Position].ToString());

            StartActivity(sessionActivityIntent);
        }
        public void WriteToFile()
        {

            
            using (StreamWriter file = new StreamWriter("/mnt/sdcard/sessions.txt"))
            {
                foreach(string session in sessions)
                {
                    file.WriteLine(session.ToString());
                }
            }
        }
        public void ReadFromFile()
        {
            FileInfo fileI = new FileInfo("/mnt/sdcard/sessions.txt");
            if (fileI.Exists)
            {
                sessions = new List<string>(File.ReadAllLines("/mnt/sdcard/sessions.txt"));
            }

        }

        public void onDeleteButtonClick()
        {

        }
        
    }
}

