import { BrainFuckIdeClientPage } from './app.po';

describe('brain-fuck-ide-client App', function() {
  let page: BrainFuckIdeClientPage;

  beforeEach(() => {
    page = new BrainFuckIdeClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
