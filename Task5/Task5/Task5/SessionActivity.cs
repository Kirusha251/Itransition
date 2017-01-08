using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Hardware;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using System.Drawing;
using System.IO;

namespace Task5
{
    [Activity(Label = "SessionActivity", ScreenOrientation = Android.Content.PM.ScreenOrientation.Portrait)]
    public class SessionActivity : Activity,Camera.IPictureCallback, Camera.IAutoFocusCallback
    {
        Camera camera;
        Camera.Parameters parameters;
        Button button;
        string currentSessionName;
        List<Android.Graphics.Bitmap> bitmapList;
        //ArrayAdapter<Android.Graphics.Bitmap> imageListAdapter;
        ImageAdapter test;
        ListView imageList;
        bool isUsed = false;
        
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.SessionLayout);
            currentSessionName = Intent.GetStringExtra("currentSession");
           
            button = FindViewById<Button>(Resource.Id.button1);
            imageList = FindViewById<ListView>(Resource.Id.ImageList);
            FindViewById<FrameLayout>(Resource.Id.frameLayout1).Click += SessionActivity_Click;
            bitmapList = new List<Android.Graphics.Bitmap>();
            button.Click += Button_Click;
            SurfaceView myView = new SurfaceView(this);
            camera = Camera.Open();
            parameters = camera.GetParameters();
            parameters.SetRotation(90);
            parameters.PictureFormat = Android.Graphics.ImageFormatType.Jpeg;
            camera.SetParameters(parameters);
            camera.SetPreviewTexture(new Android.Graphics.SurfaceTexture(10));
            loadFromDirectories();
            initializeAdapter();
            if (bitmapList.Count != 0)
            {
                button.Visibility = ViewStates.Gone;
            }
            imageList.ItemClick += ImageList_ItemClick;
            

            // Create your application here
        }

        private void SessionActivity_Click(object sender, EventArgs e)
        {
            camera.StartPreview();
            camera.TakePicture(null, null, this);
        }

        private void ImageList_ItemClick(object sender, AdapterView.ItemClickEventArgs e)
        {
            if (!isUsed)
            {
                isUsed = true;
                camera.StartPreview();
                camera.TakePicture(null, null, this);
            }
        }

        private void Button_Click(object sender, EventArgs e)
        {
            if (!isUsed)
            {
                camera.StartPreview();
                camera.TakePicture(null, null, this);
                button.Alpha = 0;
                button.Visibility = ViewStates.Gone;
            }
            
        }

        public void onButtonClick()
        {
            
        }

        public void OnPictureTaken(byte[] data, Camera camera)
        {
            Android.Graphics.Canvas canvas;
            Android.Graphics.Bitmap bitmap = Android.Graphics.BitmapFactory.DecodeByteArray(data,0,data.Length);
            Android.Graphics.Bitmap dest = Android.Graphics.Bitmap.CreateBitmap(bitmap.Width, bitmap.Height, Android.Graphics.Bitmap.Config.Argb8888);
            Android.Graphics.Paint paint = new Android.Graphics.Paint();
            paint.Color = Android.Graphics.Color.Yellow;
            paint.TextSize = 35;
            paint.SetStyle(Android.Graphics.Paint.Style.Fill);
            canvas = new Android.Graphics.Canvas(dest);
            canvas.DrawBitmap(bitmap, 0f, 0f, null);
            canvas.DrawText(DateTime.Now.ToString("MM/dd/yy H:mm:ss"), 30, 30, paint);
            FileInfo file = new FileInfo("/mnt/sdcard/" + currentSessionName + "/");
            file.Directory.Create();
            dest.Compress(Android.Graphics.Bitmap.CompressFormat.Jpeg, 100, new FileStream("/mnt/sdcard/" + currentSessionName + "/" + DateTime.Now.ToString("MM-dd-yy-H-mm-ss") + ".jpeg", FileMode.OpenOrCreate));
            bitmapList.Insert(0, dest);
            initializeAdapter();
            isUsed = false;   
            
            /*var bw = new BinaryWriter(File.Open("/mnt/sdcard/"+currentSessionName+"/"+ DateTime.Now.ToString("h:mm:ss tt")+".jpeg", FileMode.OpenOrCreate));
            bw.Write(data);*/
           
        }
       

        public void OnAutoFocus(bool success, Camera camera)
        {
            
        }
        public void loadFromDirectories()
        {
            List<FileInfo> files;
            bitmapList = new List<Android.Graphics.Bitmap>();
            FileInfo file = new FileInfo("/mnt/sdcard/" + currentSessionName + "/");
            Android.Graphics.Bitmap bitmap;
            if (file.Directory.Exists)
            {
                files = file.Directory.GetFiles().ToList<FileInfo>();
                foreach (FileInfo photo in files)
                {
                    bitmap = Android.Graphics.BitmapFactory.DecodeFile(photo.FullName);
                   
                    bitmapList.Add(bitmap);
                }
                initializeAdapter();
            }
        }
        public override void OnBackPressed()
        {
            base.OnBackPressed();
            camera.StopPreview();
            camera.Release();
            Finish();
        }
        public void initializeAdapter()
        {

            /*imageListAdapter = new ArrayAdapter<Android.Graphics.Bitmap>(this,
                Resource.Layout.myListItem, Resource.Id.image, bitmapList);
            imageList.Adapter = imageListAdapter;*/
            test = new ImageAdapter(this, bitmapList);
            imageList.Adapter = test;
            imageList.DeferNotifyDataSetChanged();
        }
    }
}