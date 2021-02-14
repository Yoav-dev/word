package ui;

import infra.FormattedCharacter;
import infra.IPrinter;

public class ConsolePrinter implements IPrinter {
	@Override
	public void print(FormattedCharacter [] content) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean openItalic = false;
		boolean openBold = false;
		boolean openUnderline = false;
		
		for (FormattedCharacter formattedCharacter : content) {
			if ((!formattedCharacter.isUnderline()) && openUnderline) {
				stringBuilder.append("</u>");
				openUnderline = false;
			}
			
			if ((!formattedCharacter.isBold()) && openBold) {
				stringBuilder.append("</b>");
				openBold = false;
			}
			
			if ((!formattedCharacter.isItalic()) && openItalic) {
				stringBuilder.append("</i>");
				openItalic = false;
			}
			
			if (formattedCharacter.isItalic() && !openItalic) {
				stringBuilder.append("<i>");
				openItalic = true;
			}
			
			if (formattedCharacter.isBold() && !openBold) {
				stringBuilder.append("<b>");
				openBold = true;
			}
			
			if (formattedCharacter.isUnderline() && !openUnderline) {
				stringBuilder.append("<u>");
				openUnderline = true;
			}
			
			stringBuilder.append(formattedCharacter.getCharacter());
		}
		
		if (content.length > 0) {
			if (content[content.length - 1].isUnderline() && openUnderline) {
				stringBuilder.append("</u>");
				openUnderline = false;
			}
			
			if (content[content.length - 1].isBold() && openBold) {
				stringBuilder.append("</b>");
				openBold = false;
			}
			
			if (content[content.length - 1].isItalic() && openItalic) {
				stringBuilder.append("</i>");
				openItalic = false;
			}
		}
		
		System.out.println(stringBuilder.toString());
	}
}