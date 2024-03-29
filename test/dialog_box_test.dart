import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:dialog_box/dialog_box.dart';

void main() {
  const MethodChannel channel = MethodChannel('dialog_box');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await DialogBox.platformVersion, '42');
  });
}
