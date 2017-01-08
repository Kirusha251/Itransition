using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Java.Lang;

namespace Task5
{
    class ImageAdapter : BaseAdapter
    {
        List<Android.Graphics.Bitmap> list;
        Activity activity;
        public ImageAdapter(Activity activity, List<Android.Graphics.Bitmap> list)
        {
            this.activity = activity;
            this.list = list;
        }
        public override int Count
        {
            get
            {
                return list.Count;
            }
        }

        public override Java.Lang.Object GetItem(int position)
        {
            throw new NotImplementedException();
        }

        public override long GetItemId(int position)
        {
            return position;
        }

        public override View GetView(int position, View convertView, ViewGroup parent)
        {
            var view = convertView ?? activity.LayoutInflater.Inflate(
                Resource.Layout.myListItem,parent,false);
            var image = view.FindViewById<ImageView>(Resource.Id.image);
            if (list != null)
            {
                image.SetImageBitmap(list[position]);
            }
            return view;
        }
    }
}