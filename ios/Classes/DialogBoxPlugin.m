#import "DialogBoxPlugin.h"
#import <dialog_box/dialog_box-Swift.h>

@implementation DialogBoxPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftDialogBoxPlugin registerWithRegistrar:registrar];
}
@end
