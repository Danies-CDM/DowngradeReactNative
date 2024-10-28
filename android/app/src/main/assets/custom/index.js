import {Platform} from 'react-native';

const fonts = {
  babasNeueRegular:
    Platform.OS === 'ios' ? 'BebasNeue-Regular' : 'bebasneue_regular',

  cabin_bold: Platform.OS === 'ios' ? 'Cabin-Bold' : 'cabin_bold',
  cabin: Platform.OS === 'ios' ? 'Cabin-Regular' : 'cabin_regular',

  gothamBold: Platform.OS === 'ios' ? 'Gotham-Bold' : 'gotham_bold',
  gothamBook: Platform.OS === 'ios' ? 'Gotham-Book' : 'gotham_book',
  gothamMedium: Platform.OS === 'ios' ? 'GothamMedium' : 'gotham_medium',

  heebo_bold: Platform.OS === 'ios' ? 'Heebo-Bold' : 'heebo_bold',
  heebo_medium: Platform.OS === 'ios' ? 'Heebo-Medium' : 'heebo_medium',
  heebo: Platform.OS === 'ios' ? 'Heebo-Regular' : 'heebo',

  interBold: Platform.OS === 'ios' ? 'Inter-Bold' : 'inter_bold',
  interMedium: Platform.OS === 'ios' ? 'Inter-Medium' : 'inter_medium',
  interRegular: Platform.OS === 'ios' ? 'Inter-Regular' : 'inter_regular',

  kaiseitokuminExtraBold:
    Platform.OS === 'ios'
      ? 'KaiseiTokumin-ExtraBold'
      : 'kaiseitokumin_extra_bold',
  kaiseitokuminRegular:
    Platform.OS === 'ios' ? 'KaiseiTokumin-Regular' : 'kaiseitokumin_regular',

  lato_bold: Platform.OS === 'ios' ? 'Lato-Bold' : 'lato_bold',
  lato_regular: Platform.OS === 'ios' ? 'Lato-Regular' : 'lato_regular',

  opensans_bold: Platform.OS === 'ios' ? 'OpenSans-Bold' : 'open_sans_bold',
  openSansRegular:
    Platform.OS === 'ios' ? 'OpenSans-Regular' : 'open_sans_regular',
  openSansSemiBold:
    Platform.OS === 'ios' ? 'OpenSans-SemiBold' : 'open_sans_semibold',

  oswaldLight: Platform.OS === 'ios' ? 'Oswald-Light' : 'oswald_light',
  oswaldMedium: Platform.OS === 'ios' ? 'Oswald-Medium' : 'oswald_medium',
  oswaldRegular: Platform.OS === 'ios' ? 'Oswald-Regular' : 'oswald_regular',

  // AEO
  avenir_next_lt_pro_bold:
    Platform.OS === 'ios'
      ? 'AvenirNextLTPro-Demi'
      : 'avenir_nextlt_pro_semibold',
  avenir_next_lt_pro_light:
    Platform.OS === 'ios' ? 'AvenirNextLTPro-Light' : 'avenir_nextlt_pro_light',
  avenir_next_lt_pro_medium:
    Platform.OS === 'ios'
      ? 'AvenirNextLTPro-Medium'
      : 'avenir_nextlt_pro_medium',
  avenir_next_lt_pro_regular:
    Platform.OS === 'ios'
      ? 'AvenirNextLTPro-Regular'
      : 'avenir_nextlt_pro_regular',
  avenir_next_lt_pro_semibold:
    Platform.OS === 'ios'
      ? 'AvenirNextLTPro-Demi'
      : 'avenir_nextlt_pro_semibold',
  avenir_next_lt_pro_thin:
    Platform.OS === 'ios' ? 'AvenirNextLTPro-Thin' : 'avenir_nextlt_pro_thin',

  // REBOOK
  neue_plak_black: Platform.OS === 'ios' ? 'NeuePlak-Black' : 'neue_plak_black',
  neue_plak_bold: Platform.OS === 'ios' ? 'NeuePlak-Bold' : 'neue_plak_bold',
  neue_plak_compressed_extrablack:
    Platform.OS === 'ios'
      ? 'NeuePlak-CompExtraBlack'
      : 'neue_plak_compressed_extrablack',
  neue_plak_condensed_extraBlack:
    Platform.OS === 'ios'
      ? 'NeuePlak-CondExtraBlack'
      : 'neue_plak_condensed_extraBlack',
  neue_plak_condensed_regular:
    Platform.OS === 'ios'
      ? 'NeuePlak-CondRegular'
      : 'neue_plak_condensed_regular',
  neue_plak_extended_black:
    Platform.OS === 'ios'
      ? 'NeuePlak-ExtendedBlack'
      : 'neue_plak_extended_black',
  neue_plak_extended_extrablack:
    Platform.OS === 'ios'
      ? 'NeuePlak-ExtendedExtraBlack'
      : 'neue_plak_extended_extrablack',
  neue_plak_extrablack:
    Platform.OS === 'ios' ? 'NeuePlak-ExtraBlack' : 'neue_plak_extrablack',
  neue_plak_light: Platform.OS === 'ios' ? 'NeuePlak-Light' : 'neue_plak_light',
  neue_plak_narrow_black:
    Platform.OS === 'ios' ? 'NeuePlak-NarrowBlack' : 'neue_plak_narrow_black',
  neue_plak_narrow_light:
    Platform.OS === 'ios' ? 'NeuePlak-NarrowLight' : 'neue_plak_narrow_light',
  neue_plak_regular:
    Platform.OS === 'ios' ? 'NeuePlak-Regular' : 'neue_plak_regular',
  neue_plak_semibold:
    Platform.OS === 'ios' ? 'NeuePlak-SemiBold' : 'neue_plak_semibold',

  nunito_sans_black:
    Platform.OS === 'ios' ? 'NunitoSans-Black' : 'nunito_sans_black',

  // F21
  din_nextlt_pro_bold:
    Platform.OS === 'ios' ? 'DINNextLTPro-Bold' : 'din_nextlt_pro_bold',
  din_nextlt_pro_medium:
    Platform.OS === 'ios' ? 'DINNextLTPro-Medium' : 'din_nextlt_pro_medium',
  din_nextlt_pro_regular:
    Platform.OS === 'ios' ? 'DINMittelschriftStd' : 'din_nextlt_pro_regular',

  source_sans_pro_bold:
    Platform.OS === 'ios' ? 'SourceSansPro-Bold' : 'source_sans_pro_bold',
  source_sans_pro_light:
    Platform.OS === 'ios' ? 'SourceSansPro-Light' : 'source_sans_pro_light',
  source_sans_pro_regular:
    Platform.OS === 'ios' ? 'SourceSansPro-Regular' : 'source_sans_pro_regular',
  source_sans_pro_semibold:
    Platform.OS === 'ios'
      ? 'SourceSansPro-Semibold'
      : 'source_sans_pro_semibold',

  // SC
  akshar_bold: Platform.OS === 'ios' ? 'Akshar-Bold' : 'akshar_bold',
  akshar_medium: Platform.OS === 'ios' ? 'Akshar-Medium' : 'akshar_medium',
  akshar_regular: Platform.OS === 'ios' ? 'Akshar-Light' : 'akshar_light',

  roboto_condensed_regular:
    Platform.OS === 'ios'
      ? 'RobotoCondensed-Regular'
      : 'roboto_condensed_regular',

  akshar_pro_bold: Platform.OS === 'ios' ? 'Akshar-Bold' : 'akshar_bold',
  akshar_pro_light: Platform.OS === 'ios' ? 'Akshar-Light' : 'akshar_light',
  akshar_pro_medium: Platform.OS === 'ios' ? 'Akshar-Medium' : 'akshar_medium',
  akshar_pro_regular: Platform.OS === 'ios' ? 'Akshar-Light' : 'akshar_light',
  akshar_pro_semi_bold: Platform.OS === 'ios' ? 'Akshar-Bold' : 'akshar_bold',

  silkscreen_regular:
    Platform.OS === 'ios' ? 'Silkscreen-Regular' : 'silkscreen_regular',
  silkscreen_bold:
    Platform.OS === 'ios' ? 'Silkscreen-Bold' : 'silkscreen_bold',
};
export default fonts;
