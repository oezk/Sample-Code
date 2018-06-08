from html.parser import HTMLParser

class MyHTMLParser(HTMLParser):
    def handle_starttag(self, tag, attrs):
        print ("Start : {}".format(tag))
        for attr in attrs:
            print ("-> {} > {}".format(attr[0],attr[1]))

    def handle_endtag(self, tag):
        print ("End   : {}".format(tag))

    def handle_startendtag(self, tag, attrs):
        print ("Empty :",tag)
        for attr in attrs:
            print ("->",attr[0],">",attr[1])
        
parser = MyHTMLParser()
for r in range(int(input())):
    parser.feed(input())