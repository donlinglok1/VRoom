/* ------  ViewController.h ------ */
#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
@property (strong, nonatomic) IBOutlet UIWebView *viewWeb;

@end

/* ------ ViewController.m ------ */
#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
		//basic mode with server demo image
    NSString *fullURL = @"https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/";
    NSURL *url = [NSURL URLWithString:fullURL];
    NSURLRequest *requestObj = [NSURLRequest requestWithURL:url];
    [_viewWeb loadRequest:requestObj];
    
		//AR mode, please use mobile device testing
    NSString *fullURL = @"https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=AR";
    NSURL *url = [NSURL URLWithString:fullURL];
    NSURLRequest *requestObj = [NSURLRequest requestWithURL:url];
    [_viewWeb loadRequest:requestObj];
    
		//VR mode, please use mobile device testing
		//You can use full path to load image, but make sure it fit "Cross-Origin Resource Sharing policy"
    NSString *fullURL = @"https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=VR";
    NSURL *url = [NSURL URLWithString:fullURL];
    NSURLRequest *requestObj = [NSURLRequest requestWithURL:url];
    [_viewWeb loadRequest:requestObj];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

@end
