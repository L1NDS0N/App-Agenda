import { AgendaUiPage } from './app.po';

describe('agenda-ui App', () => {
  let page: AgendaUiPage;

  beforeEach(() => {
    page = new AgendaUiPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
