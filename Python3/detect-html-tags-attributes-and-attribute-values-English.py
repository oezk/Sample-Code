from html.parser import HTMLParser

class MyHTMLParser(HTMLParser):
    def handle_starttag(self, tag, attrs):
        print ("{}".format(tag))
        for attr in attrs:
            print ("-> {} > {}".format(attr[0],attr[1]))

    def handle_startendtag(self, tag, attrs):
        print (tag)
        for attr in attrs:
            print ("->",attr[0],">",attr[1])
        
parser = MyHTMLParser()
for r in range(int(input())):
    parser.feed(input())