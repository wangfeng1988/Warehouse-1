/*
 * 打开新窗口
 * f:链接地址
 * n:窗口的名称
 * w:窗口的宽度
 * h:窗口的高度
 */
function openFormWin(f, n, w, h)
{
	l = (screen.width - w) / 2;
	t = (screen.height - h) / 2;
	sFeatures = "left="
			+ l
			+ ",top="
			+ t
			+ ",height="
			+ h
			+ ",width="
			+ w
			+ ",center=1,scrollbars=yes,status=0,resizable=yes,directories=0,channelmode=0";
	openwin = window.open(f, n, sFeatures);
	if (!openwin.opener)
		openwin.opener = self;
	openwin.focus();
	return openwin;
}