using Android.App;
using Android.Widget;
using Android.OS;

namespace TicTacToe
{
	[Activity (Label = "TicTacToe", MainLauncher = true, Icon = "@mipmap/icon")]
	public class MainActivity : Activity
	{

		protected override void OnCreate (Bundle savedInstanceState)
		{
			base.OnCreate (savedInstanceState);

			// Set our view from the "main" layout resource
			SetContentView (Resource.Layout.Main);
		}

		public void setImg(ImageView View)
		{
			ImageView imageView = FindViewById<ImageView>(Resource.Id.imageView0);
		//	ImageView.SetImageResource (Resource.Drawable.rondje);
		}
	}
}